package com.jam.orderapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int custid;
	private String name; // just to label the customer
	private Double funds;

	public Customer() {
	}
	
	public Customer(String name, Double funds) {
		super();
		this.name = name;
		this.funds = funds;
	}


	public Customer(int custid, String name, Double funds) {
		super();
		this.custid = custid;
		this.name = name;
		this.funds = funds;
	}

	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getFunds() {
		return funds;
	}
	public void setFunds(Double funds) {
		this.funds = funds;
	}

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", name=" + name + ", funds=" + funds + "]";
	}



	
}
