package com.oracle.productapiservice;

import java.io.File;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("products")
public class ProductService {

	private DaoContract<ProductDTO, Integer> dao;

	// Identifies injectable constructors, methods, and fields
	@Inject
	public ProductService(DaoContract<ProductDTO, Integer> dao) {
		this.dao = dao;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("all")
	public Response getProducts() {
		try {
//			ResponseBuilder builder = Response.status(200);
//			builder.entity(dao.getAll());
//			Response okresponse = builder.build(); 
//			return okresponse;
			return Response.status(200).entity(dao.getAll()).build();
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getData() {
		return new File("").getAbsolutePath();
	}
}
