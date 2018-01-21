package com.itbz.BookStore.po;

import java.util.Date;



/**
 * 用户订单类
 * @author yalong
 *
 */
public class Item {

	private String createDate;
	
	private Integer id;
	/**
	 * 该订单由那个用户下
	 */
	private Users user;
	/**
	 * 书籍
	 */
	private Book book;
	/**
	 * 订单创建时间
	 */
	private Date createdate;
	
	/**
	 * 书籍数量
	 */
	private Integer count; 
	/**
	 * 单价
	 */
	private Double price; 
	
	/**
	 * 总价
	 */
	private Double totalprice;
	
	/**
	 * 订单状态
	 */
	private Integer status;

	/**
	 * 用户id
	 */
	private Integer uid;
	/**
	 * 书id
	 * @return
	 */
	private Integer bid;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", user=" + user + ", book=" + book
				+ ", createdate=" + createdate + ", count=" + count
				+ ", price=" + price + ", totalprice=" + totalprice
				+ ", status=" + status + "]";
	}
}
