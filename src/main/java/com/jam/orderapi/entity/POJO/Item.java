package com.jam.orderapi.entity.POJO;

public class Item {
	
	int productId;
	int quatity;
	
	public Item(int productId, int quatity) {
		this.productId = productId;
		this.quatity = quatity;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuatity() {
		return quatity;
	}
	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}
	@Override
	public String toString() {
		return "Item [productId=" + productId + ", quatity=" + quatity + "]";
	}
	
	
}
