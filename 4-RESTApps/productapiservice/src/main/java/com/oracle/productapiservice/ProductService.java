package com.oracle.productapiservice;

import java.net.URI;
import java.sql.SQLException;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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
			return Response.status(200).entity(dao.getAll()).build();
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getProductById(@PathParam("id") int id) {
		try {
			return Response.ok(dao.get(id)).build();
		} catch (ClassNotFoundException e) {
			return Response.serverError().entity(e.getMessage()).build();
		} catch (SQLException e) {
			return Response.serverError().entity(e.getMessage()).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("add")
	public Response addProduct(ProductDTO dto) {
		try {
			System.out.println(dto);
			int res = dao.add(dto);
			if (res > 0)
				return Response.created(URI.create("add")).entity(dto).build();
			else
				return Response.status(500, "could not add record").build();

		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("update/{id}")
	public Response updateProduct(@PathParam("id") int id, ProductDTO dto) {
		try {
			System.out.println(dto);
			int res = dao.update(id, dto);
			if (res > 0)
				return Response.status(200).entity(dto).build();
			else
				return Response.status(500, "could not update record").build();

		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delete/{id}")
	public Response deleteProduct(int id) {
		try {
			ProductDTO dto = dao.get(id);
			int res = dao.delete(id);
			if (res > 0)
				return Response.status(200).entity(dto).build();
			else
				return Response.status(500, "could not delete record").build();

		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
}
