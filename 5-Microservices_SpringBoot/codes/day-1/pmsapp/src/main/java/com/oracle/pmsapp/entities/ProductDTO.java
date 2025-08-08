package com.oracle.pmsapp.entities;

import java.time.LocalDate;

public class ProductDTO {
	private int id;
	private String name;
	private float price;
	private String description;
	private LocalDate releasedOn;
	private int categoryId;
	
	public ProductDTO() {
	}
	
	public ProductDTO(int id, String name, float price, String description, LocalDate releasedOn, int categoryId) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.releasedOn = releasedOn;
		this.categoryId = categoryId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDate getReleasedOn() {
		return releasedOn;
	}
	public void setReleasedOn(LocalDate releasedOn) {
		this.releasedOn = releasedOn;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
