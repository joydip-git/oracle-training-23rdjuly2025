package com.oracle.hibernatewithboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.oracle.hibernatewithboot.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
