package com.oracle.pmsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.pmsapp.entities.ProductDTO;
import com.oracle.pmsapp.repository.DaoContract;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private DaoContract<ProductDTO, Integer> dao;

	@GetMapping("/all")
	public ResponseEntity<List<ProductDTO>> getProducts() {
		try {
			return new ResponseEntity<List<ProductDTO>>(dao.getAll(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<ProductDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
