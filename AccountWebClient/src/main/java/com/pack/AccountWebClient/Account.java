package com.pack.AccountWebClient;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private double amount;
	private String type;
	private String name;
	
	public Account(Integer id, double amount, String type, String name) {
		super();
		this.id = id;
		this.amount = amount;
		this.type = type;
		this.name = name;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", amount=" + amount + ", type=" + type + ", name=" + name + "]";
	}
	
   
}
