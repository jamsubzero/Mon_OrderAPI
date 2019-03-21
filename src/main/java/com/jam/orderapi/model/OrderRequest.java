package com.jam.orderapi.model;


public class OrderRequest {

	private int custId;
	private Double price;
	
	public OrderRequest() {
	
	}

	public OrderRequest(int custId, Double price) {
		this.custId = custId;
		this.price = price;
	}
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderRequest [custId=" + custId + ", price=" + price + "]";
	}
	
	
	
	
	
}
