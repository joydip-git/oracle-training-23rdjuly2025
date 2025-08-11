package com.oracle.hibernatewithannotation;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "product_id", nullable = false)
	private int productId;

	@Column(name = "product_name", nullable = false)
	private String productName;
	
	@Column(name = "product_desc")
	private String description;
	
	@Column(name = "product_price")
	private float price;
	
	@Column(name = "product_released_on")
	private Date releasedOn;
	
	@Column(name = "category_id")
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
