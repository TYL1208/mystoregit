package com.itbz.BookStore.ServiceImp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbz.BookStore.Service.ItemService;
import com.itbz.BookStore.dao.BookDao;
import com.itbz.BookStore.dao.ItemDao;
import com.itbz.BookStore.po.Book;
import com.itbz.BookStore.po.Item;
import com.mysql.fabric.xmlrpc.base.Data;

/**
 * 订单业务实现层
 * @author yalong
 *
 */
@Service
public class ItemServiceImp implements ItemService {

	@Autowired
	ItemDao iDao;
	
	@Autowired
	BookDao bd;
	
	public int savaItem(Book book) {
		Item item = new Item();
		item.setBid(book.getId());
		item.setCreatedate(new Date());
		item.setCount(1);
		item.setPrice(book.getPrice());
		item.setTotalprice(book.getPrice());
		item.setUid(book.getUid());
		item.setStatus(0);
	  int i=iDao.savaItem(item);
		return i;
	}
	/**
	 * 查询所有购物车订单
	 */
	public List<Item> checkAllItem(int uid) {
		List<Item> itlist=iDao.checkAllItems(uid);
		if (itlist.size()>0) {
			return itlist;
		}else {
			return null;
		}
	}
	/**
	 * 修改用户订单状态
	 */
	public int updataItemsStatus(ArrayList<Integer> intid) {
		Map<String , Object> itemsmap= new HashMap<String, Object>();
		itemsmap.put("intid", intid);
		int i= iDao.updataItemsStatus(itemsmap);
		return i;
	}
	/**
	 * 修改库存
	 */
	public void updatebookStock(ArrayList<Integer> intid) {
		Map<String , Object> itemsmap= new HashMap<String, Object>();
		itemsmap.put("intids", intid);
		//查询书籍id
	    ArrayList<Integer> bids=iDao.checkItemsByids(itemsmap);
	    for (Integer id : bids) {
	    	//查询书籍
		 Book book =bd.checkBookById(id);
		 //修改库存
		 int upStock= book.getStock()-1;
		 bd.upBookStock(upStock,id);
		}
	}
	/**
	 * 查看我的订单
	 */
	public List<Item> checkMyItem(Integer uid) {
		List<Item> itlist=iDao.checkMyItem(uid);
		for (Item item : itlist) {
			Date date  = item.getCreatedate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String createDate = sdf.format(date);
			item.setCreateDate(createDate);
		}
		if (itlist.size()>0) {
			return itlist;
		}else {
			return null;
		}
	}

}
