package com.itbz.BookStore.dao;



import com.itbz.BookStore.po.Users;

public interface UserDao {

	Users checkUser(Users user);

	int savaUsers(Users users);

}
