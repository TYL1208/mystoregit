package com.itbz.BookStore.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbz.BookStore.Service.BookService;
import com.itbz.BookStore.dao.BookDao;
import com.itbz.BookStore.po.Book;

/**
 * 书籍业务实现类
 * @author yalong
 *
 */
@Service
public class BookServiceImp implements BookService {

	@Autowired
	BookDao bd;
	
	/**
	 * 查询所有书籍
	 */
	
	public List<Book> checkAllBooks() {
		List<Book> books =	bd.checkAllBooks();
		if(books.size()>0){
			return books;
		}else {
			return null;
		}
	}

}
