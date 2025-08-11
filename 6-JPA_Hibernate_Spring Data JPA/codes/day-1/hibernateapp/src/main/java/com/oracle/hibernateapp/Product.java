package com.oracle.hibernateapp;

import java.util.Date;

public class Product {
	private int productId;
	private String productName;
	private String description;
	private float price;
	private Date releasedOn;
	private int categoryId;
	
	public Product() {
	}
	
	public Product(int productId, String productName, String description, float price, Date releasedOn,
			int categoryId) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.releasedOn = releasedOn;
		this.categoryId = categoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getReleasedOn() {
		return releasedOn;
	}

	public void setReleasedOn(Date releasedOn) {
		this.releasedOn = releasedOn;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}	
}
