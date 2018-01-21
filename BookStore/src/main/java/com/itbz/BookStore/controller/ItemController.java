package com.itbz.BookStore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itbz.BookStore.Service.ItemService;
import com.itbz.BookStore.po.Book;
import com.itbz.BookStore.po.Item;

/**
 * 订单处理层
 * @author yalong
 *
 */
@Controller
public class ItemController {

	@Autowired
	ItemService ites;
	/**
	 * 保存购物车信息
	 * @param book
	 * @param map
	 * @return
	 */
	@RequestMapping("addItem.action")
	public String addItems(Book book,ModelMap map){
		if(book.getUid()==null){
			return "resign.jsp";
		}
	 int status=ites.savaItem(book);
	 List<Item> itList= ites.checkAllItem(book.getUid());
	 map.addAttribute("items", itList);
		return "showItems.jsp";
		
	}
	/**
	 * 提交订单
	 * @return
	 */
	@RequestMapping("payItems.action")
	@ResponseBody
	public int payItem(@RequestParam("itmid") String countid){
		String[] itemsid = countid.split(" ");
		ArrayList<Integer> intid= new ArrayList();
		for (int i = 0; i < itemsid.length; i++) {
	     intid.add(Integer.parseInt(itemsid[i]));
		}
		//修改订单状态	
	    int status=ites.updataItemsStatus(intid);
	    //修改书籍库存
	    ites.updatebookStock(intid);
		return status;
		
	}
	
	/**
	 * 查看购物车
	 * @param map
	 * @return
	 */
	@RequestMapping("showItem.action")
	public String showItems(@RequestParam("uid") Integer uid,ModelMap map){
		if (uid==null) {
			return "resign.jsp";
		}
		 List<Item> itList= ites.checkAllItem(uid);
		 map.addAttribute("items", itList);
		return "showItems.jsp";
		
	}
	/**
	 * 查看我的订单
	 */
	@RequestMapping("showMyItems.action")
	public String showMyItems(ModelMap map,@RequestParam("uid") Integer uid ){
		if (uid==null) {
			return "resign.jsp";
		}
		 List<Item> itList= ites.checkMyItem(uid);
		 map.addAttribute("items", itList);
		return "showMyItems.jsp";
		
	}
}
