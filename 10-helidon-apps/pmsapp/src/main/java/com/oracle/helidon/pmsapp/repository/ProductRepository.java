package com.oracle.helidon.pmsapp.repository;

import java.util.List;

import com.oracle.helidon.pmsapp.entities.Product;
import com.oracle.helidon.pmsapp.entities.Category;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Dependent
public class ProductRepository implements RepositoryContract<Product, Integer> {

    @PersistenceContext(name = "DbPersistenceContext")
    private EntityManager manager;

    @Override
    @Transactional
    public Product add(Product data) {
        try {
            int categoryId = data.getCategoryId();
            Category category = manager.find(Category.class, categoryId);
            if (category != null) {
                category.getProducts().add(data);
                data.setCategory(category);
                manager.persist(data);
                return data;
            } else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public Product delete(Integer id) throws Exception {
        try {
            Product p = manager.find(Product.class, id);
            if (p != null) {
                manager.remove(p);
                return p;
            } else
                throw new Exception("the product does not exist");
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Product get(Integer id) {
        try {
            TypedQuery<Product> query = manager
                    .createNamedQuery("getProductById", Product.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Product> getAll() {
        try {
            return manager
                    .createNamedQuery("getAllProducts", Product.class)
                    .getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public Product update(Integer id, Product data) throws Exception {
        try {
            Product product = manager.find(Product.class, id);
            if (product != null) {
                product.setCategoryId(data.getCategoryId());
                product.setProductName(data.getProductName());
                product.setProductDescription(
                        data.getProductDescription());
                product.setProductPrice(data.getProductPrice());
                product.setProductReleasedOn(data.getProductReleasedOn());
                Category c = manager.find(Category.class, data.getCategoryId());
                product.setCategory(c);
                manager.merge(product);
                return data;
            } else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
