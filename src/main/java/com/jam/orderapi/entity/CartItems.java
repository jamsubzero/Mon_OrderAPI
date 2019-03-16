package com.jam.orderapi.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItems {

	@Id
	@GeneratedValue
	private int cartItemId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trans_transid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Transaction transaction;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pro_proid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Product product;
	private int quantity;
	
	public CartItems() {
	}
	
	public CartItems(Transaction transaction, Product product, int quantity) {
		this.transaction = transaction;
		this.product = product;
		this.quantity = quantity;
	}
	
	public CartItems(int cartItemId, Transaction transaction, Product product, int quantity) {
		this.cartItemId = cartItemId;
		this.transaction = transaction;
		this.product = product;
		this.quantity = quantity;
	}
	
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartItems [cartItemId=" + cartItemId + ", transaction=" + transaction + ", product=" + product
				+ ", quantity=" + quantity + "]";
	}
	
	
	
	
	
	
	
	
}
