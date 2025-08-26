package com.oracle.helidon.pmsapp.entities;

import java.time.LocalDate;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.ws.rs.DefaultValue;

@Entity(name = "Product")
@Table(name = "products")
@Access(AccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "getAllProducts", query = "SELECT p from Product p"),
        @NamedQuery(name = "getProductById", query = "SELECT p from Product p where p.productId=:id")
})
public class Product {

    @Id
    @Column(name = "product_id", nullable = false, updatable = false, insertable = true)
    private int productId;

    @Basic(optional = false)
    @Column(name = "product_name", updatable = true, insertable = true)
    private String productName;

    @Basic(optional = true)
    @Column(name = "product_price", updatable = true, insertable = true, nullable = true)
    @DefaultValue(value = "0")
    private float productPrice;

    @Basic(optional = true)
    @Column(name = "product_desc", updatable = true, insertable = true, nullable = true)
    private String productDescription;

    @Basic(optional = true)
    @Column(name = "product_released_on", updatable = true, insertable = true, nullable = true)
    private LocalDate productReleasedOn;

    // @Basic(optional = true)
    // @Column(name = "category_id", updatable = true, insertable = true)
    @Transient
    private int categoryId;

    @ManyToOne(targetEntity = Category.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = true, insertable = true, updatable = true)
    private Category category;

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int id) {
        this.productId = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float price) {
        this.productPrice = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String description) {
        this.productDescription = description;
    }

    public LocalDate getProductReleasedOn() {
        return productReleasedOn;
    }

    public void setProductReleasedOn(LocalDate releasedOn) {
        this.productReleasedOn = releasedOn;
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
