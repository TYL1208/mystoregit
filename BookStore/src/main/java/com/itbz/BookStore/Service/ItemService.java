package com.itbz.BookStore.Service;

import java.util.ArrayList;
import java.util.List;

import com.itbz.BookStore.po.Book;
import com.itbz.BookStore.po.Item;

public interface ItemService {

	int savaItem(Book book);

	List<Item> checkAllItem(int id);

	int updataItemsStatus(ArrayList<Integer> intid);

	void updatebookStock(ArrayList<Integer> intid);

	List<Item> checkMyItem(Integer uid);

}
