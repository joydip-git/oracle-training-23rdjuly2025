package com.oracle.hibernatewithboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.oracle.hibernatewithboot.models.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	Iterable<Product> filterByProductName(String name);
}
