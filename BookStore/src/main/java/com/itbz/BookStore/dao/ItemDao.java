package com.itbz.BookStore.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.itbz.BookStore.po.Item;

public interface ItemDao {

	int savaItem(Item item);

	List<Item> checkAllItems(int uid);

	int updataItemsStatus(Map<String , Object> itemsmap);

	ArrayList<Integer> checkItemsByids(Map<String, Object> itemsmap);

	List<Item> checkMyItem(Integer uid);
}
