package com.itbz.BookStore.Service;

import java.util.ArrayList;

import com.itbz.BookStore.po.Users;

public interface UserService {

	ArrayList<Integer> checkUser(Users user);

	int checkRegin(Users users);

}
