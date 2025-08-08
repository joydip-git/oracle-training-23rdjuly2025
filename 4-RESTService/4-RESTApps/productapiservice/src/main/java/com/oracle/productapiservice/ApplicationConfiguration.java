package com.oracle.productapiservice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfiguration extends ResourceConfig {

	public static final String DB_SETTINGS_PATH = "db.properties";
	public static final Properties DB_PROPERTIES = new Properties();

	public ApplicationConfiguration() {
		this.packages("com.oracle.productapiservice");
		this.register(new AppServiceBinder());
		loadConfiguration();
	}

	private void loadConfiguration() {
		try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(DB_SETTINGS_PATH)) {
			if (inputStream != null) {
				DB_PROPERTIES.load(inputStream);
			} else {
				System.err.println("Properties file not found: " + DB_SETTINGS_PATH);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
