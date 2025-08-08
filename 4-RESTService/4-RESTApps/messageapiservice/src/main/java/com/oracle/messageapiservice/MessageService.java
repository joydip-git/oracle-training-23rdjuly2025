package com.oracle.messageapiservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("message")
public class MessageService {

	@GET
	@Path("welcome/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String sayWelcome(@PathParam("name") String name) {
		return "welcome to jersey " + name;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage() {
		return new Message("Welcome to ", "Jersey");
	}
}
