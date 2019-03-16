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
public class Transaction{

	@Id
	@GeneratedValue
	private int transid;
	private Double totalprice;
	private int status; //1 accepted, 0 not accepted
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_custid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Customer customer;
	
	
	public Transaction() {
	}
	
	public Transaction(Customer customer, Double totalprice, int status) {
		this.customer = customer;
		this.totalprice = totalprice;
		this.status = status;
	}
	
	public Transaction(int transid, Customer customer, Double totalprice, int status) {
		this.transid = transid;
		this.customer = customer;
		this.totalprice = totalprice;
		this.status = status;
	}
	
	public int getTransid() {
		return transid;
	}
	public void setTransid(int transid) {
		this.transid = transid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Transaction [transid=" + transid + ", customer=" + customer + ", totalprice=" + totalprice + ", status="
				+ status + "]";
	}

		
	
	
	
}
