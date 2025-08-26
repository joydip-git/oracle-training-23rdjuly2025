package com.oracle.helidon.pmsapp.controllers;

import java.util.List;

import com.oracle.helidon.pmsapp.entities.Product;
import com.oracle.helidon.pmsapp.repository.RepositoryContract;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/products")
@ApplicationScoped

public class ProductController {

    @Inject
    private RepositoryContract<Product, Integer> repository;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        try {
            List<Product> products = repository.getAll();
            if (products.isEmpty())
                throw new NotFoundException("products not found");
            else
                return products;
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @GET
    @Path("/view/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") int productId) {
        try {
            Product product = repository.get(productId);
            return product;
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product addProduct(Product product) {
        try {
            return repository.add(product);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product updateProduct(@PathParam("id") int productId, Product product) {
        try {
            return repository.update(productId, product);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product deleteProduct(@PathParam("id") int productId) {
        try {
            return repository.delete(productId);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
