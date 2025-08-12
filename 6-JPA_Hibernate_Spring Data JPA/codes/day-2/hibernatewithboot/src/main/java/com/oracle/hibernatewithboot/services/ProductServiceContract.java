package com.oracle.hibernatewithboot.services;

import java.util.List;

import com.oracle.hibernatewithboot.models.Product;

public interface ProductServiceContract extends ServiceContract<Product, Integer>{
	List<Product> filterProductsByName(String productName);
}
