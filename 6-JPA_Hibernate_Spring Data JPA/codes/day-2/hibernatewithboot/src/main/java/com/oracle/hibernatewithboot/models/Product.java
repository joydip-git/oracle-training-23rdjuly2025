package com.oracle.hibernatewithboot.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "product_id", nullable = false)
	private int productId;

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "product_desc", nullable = true)
	private String productDescription;

	@Column(name = "product_price")
	private double productPrice;

	@Column(name = "product_released_on")
	private Date productReleasedOn;

	@Column(name = "category_id")
	private int categoryId;

	@JsonIgnore
	@ManyToOne(targetEntity = Category.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;

	public Product() {
	}

	public Product(int productId, String productName, String productDescription, double productPrice,
			Date productReleasedOn, int categoryId) {
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productReleasedOn = productReleasedOn;
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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Date getProductReleasedOn() {
		return productReleasedOn;
	}

	public void setProductReleasedOn(Date productReleasedOn) {
		this.productReleasedOn = productReleasedOn;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
