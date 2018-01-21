package com.itbz.BookStore.ServiceImp;

import java.util.ArrayList;

import javax.xml.registry.JAXRException;
import javax.xml.registry.infomodel.InternationalString;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbz.BookStore.Service.UserService;
import com.itbz.BookStore.dao.UserDao;
import com.itbz.BookStore.po.Users;

/**
 * 用户业务实现类
 * @author yalong
 *
 */
@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDao udDao;

	/**
	 * 登入查询用户是否存在
	 */
	public ArrayList<Integer> checkUser(Users user) {
	 ArrayList<Integer> statu= new ArrayList();	
	 Users users =udDao.checkUser(user);
	 String loginName = user.getName();
	 String checkName = users.getName();
	 String loginPassword = user.getPassword();
	 String checkPassword = user.getPassword();
	 statu.add(users.getId());
	 if(loginName!=null&&loginPassword!=null){
		 if(loginName.equals(checkName)){
			 //用户名和密码都匹配
			 if(loginPassword.equals(checkPassword)){
				 statu.add(1);
				 return statu;
			 }else {
				 //密码错误
				 statu.add(2);
				 return statu;
			 }
		 }else {
			 //用户不存在
			 statu.add(0);
			 return statu;
		 }
	 }else {
		 statu.add(0);
		 return statu;
	}
	}

	/**
	 * 用户注册功能
	 */
	public int checkRegin(Users users) {
		Users checkUser = udDao.checkUser(users);
		if(checkUser!=null){
			//用户已存在
			return 2;
		}else {
		int status =udDao.savaUsers(users);
		return status;
		}
	}
}
