package com.itbz.BookStore.po;

/**
 * 用户实体类
 * @author yalong
 *
 */
public class Users {

	private Integer id;
	
	/**
	 * 用户名
	 */
	private String name;
	
	/**
	 * 用户密码
	 */
	private String password;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", password=" + password
				+ "]";
	}
}
