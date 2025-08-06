package com.oracle.productapiservice;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class App {

	public static final String BASE_URI = "http://localhost:9000/";

	public static HttpServer startServer() {
		final ResourceConfig rc = new ResourceConfig();
		rc.packages("com.oracle.productapiservice");
		URI uri = URI.create(BASE_URI);
		return GrizzlyHttpServerFactory.createHttpServer(uri, rc);
	}

	public static void main(String[] args) throws IOException {
		final HttpServer server = startServer();
		server.start();
		System.out.println(String.format("Product Service started at %s", BASE_URI, "message"));
		System.out.println("Hit enter to stop the server...");
		System.in.read();
		server.shutdownNow();
	}
}
