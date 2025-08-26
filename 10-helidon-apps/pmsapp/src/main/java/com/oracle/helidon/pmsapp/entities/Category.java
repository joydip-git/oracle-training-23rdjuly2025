package com.oracle.helidon.pmsapp.entities;

import java.util.List;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "Category")
@Table(name = "categories")
@Access(AccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "getCategories", query = "SELECT c FROM Category c"),
        @NamedQuery(name = "getCategoryById", query = "SELECT c FROM Category c where c.categoryId=:id"),
})
public class Category {

    @Id
    @Column(name = "category_id", nullable = false, updatable = false)
    private int categoryId;

    @Basic(optional = false)
    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @JsonbTransient
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}