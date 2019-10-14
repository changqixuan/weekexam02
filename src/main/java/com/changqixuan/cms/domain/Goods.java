/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: Goods.java 
 * @Prject: week02
 * @Package: com.changqixuan.cms.domain 
 * @Description: TODO
 * @author: lenovo   
 * @date: 2019年10月14日 上午8:46:06 
 * @version: V1.0   
 */
package com.changqixuan.cms.domain;

import java.io.Serializable;
/** 
 * @ClassName: Goods 
 * @Description: TODO
 * @author: 常琪宣
 * @date: 2019年10月14日 上午8:46:06  
 */
public class Goods implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String name;
	private String price;
	private String bfb;
	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param bfb
	 */
	public Goods(String id, String name, String price, String bfb) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.bfb = bfb;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", bfb=" + bfb + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBfb() {
		return bfb;
	}
	public void setBfb(String bfb) {
		this.bfb = bfb;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * 
	 */
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
}
