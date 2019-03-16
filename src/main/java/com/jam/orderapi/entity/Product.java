package com.jam.orderapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int proid;
	private String title;
	private String description;
	private Double price;
		
	public Product() {
	}
	
	public Product(String title, String description, Double price) {
		this.title = title;
		this.description = description;
		this.price = price;
	}

	public Product(int proid, String title, String description, Double price) {
		this.proid = proid;
		this.title = title;
		this.description = description;
		this.price = price;
	}
	
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [proid=" + proid + ", title=" + title + ", description=" + description + ", price=" + price
				+ "]";
	}
	
	
	
	
}
