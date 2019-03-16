package com.jam.orderapi.entity.POJO;

import java.util.List;

public class ClientOrder {
  
	int custid;
	List<Item> items;
	
	public ClientOrder(int custid, List<Item> items) {
		this.custid = custid;
		this.items = items;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return "ClientOrder [custid=" + custid + ", items=" + items + "]";
	}
	
	
	
	
	
	
}
