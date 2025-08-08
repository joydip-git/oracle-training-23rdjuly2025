package com.oracle.pmsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication //(exclude = DataSourceAutoConfiguration.class)
public class PmsappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmsappApplication.class, args);
	}

}
