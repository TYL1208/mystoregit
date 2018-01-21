package com.itbz.BookStore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itbz.BookStore.po.Book;

public interface BookDao {

	List<Book> checkAllBooks();

	Book checkBookById(Integer id);

	void upBookStock(@Param("stock")int upStock,@Param("id") Integer id);
}
