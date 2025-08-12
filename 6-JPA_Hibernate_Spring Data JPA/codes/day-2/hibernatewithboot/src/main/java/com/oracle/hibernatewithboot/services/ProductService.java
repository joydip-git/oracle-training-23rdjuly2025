package com.oracle.hibernatewithboot.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.hibernatewithboot.models.Product;
import com.oracle.hibernatewithboot.repository.ProductRepository;

@Service
//public class ProductService implements ServiceContract<Product, Integer> {
public class ProductService implements ProductServiceContract {

	@Autowired
	private ProductRepository repository;

	@Override
	public Product add(Product data) {
		try {
			return repository.save(data);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Product update(Integer id, Product data) {
		try {
			Product found = repository.findById(id.intValue()).get();
			if (Objects.nonNull(found)) {
				found.setProductName(data.getProductName());
				found.setProductPrice(data.getProductPrice());
				found.setProductDescription(data.getProductDescription());
				found.setCategoryId(data.getCategoryId());
				found.setProductReleasedOn(data.getProductReleasedOn());
			}
			return repository.save(found);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			repository.deleteById(id.intValue());
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Iterable<Product> getAll() {
		try {
			List<Product> records = (List<Product>) repository.findAll();
			if (Objects.nonNull(records) && records.size() > 0) {
				return records.stream().sorted((p1, p2) -> p1.getProductId() - p2.getProductId()).toList();
			} else
				return null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Product get(Integer id) {
		try {
			Product found = repository.findById(id.intValue()).get();
			return found;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Product> filterProductsByName(String productName) {
		try {
			List<Product> products = (List<Product>) repository.filterByProductName(productName);
			return products.stream().filter((p) -> p.getProductName().toLowerCase().contains(productName.toLowerCase()))
					.toList();
		} catch (Exception e) {
			throw e;
		}
	}
}
