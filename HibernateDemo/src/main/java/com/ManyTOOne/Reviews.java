package com.ManyTOOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reviews {
	@Id
	private int rid;
	private String msg;
	@ManyToOne
	private Product product;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Reviews(int rid, String msg, Product product) {
		super();
		this.rid = rid;
		this.msg = msg;
		this.product = product;
	}
	public Reviews() {
		super();
	}
	
}
