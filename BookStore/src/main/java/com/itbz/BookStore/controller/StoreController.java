package com.itbz.BookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbz.BookStore.Service.BookService;
import com.itbz.BookStore.po.Book;
import com.itbz.BookStore.util.PageUtil;

/**
 * 商店中心处理类
 * @author yalong
 *
 */
@Controller
@RequestMapping("store")
public class StoreController {

	@Autowired
	BookService bs;
	
	@RequestMapping("StoreCent.action")
	public String ShowBooks(ModelMap map){
	 List <Book>  books= bs.checkAllBooks();
	 map.addAttribute("books", books);
		return "../showBooks.jsp";
	}
	
}
