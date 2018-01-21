package com.itbz.BookStore.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.xml.registry.infomodel.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itbz.BookStore.Service.UserService;
import com.itbz.BookStore.po.Users;

/**
 * 用户处理类
 * @author yalong
 *
 */
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService us;
	
	/**
	 * 用户登入功能
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("login.action")
	public int login(Users user,HttpServletRequest request){
		ArrayList<Integer> status=	us.checkUser(user);
		user.setId(status.get(0));
	//如果登入成功,将user信息放入session中
	if(status.get(1)==1){
		request.getSession().setAttribute("user", user);
	}
		return status.get(1);
	}
	
	/**
	 * 用户注册功能
	 * @return
	 */
	@ResponseBody
	@RequestMapping("regin.action")
	public int regin(Users users ){
		int checkUser = us.checkRegin(users);
		return checkUser;
	}
}
