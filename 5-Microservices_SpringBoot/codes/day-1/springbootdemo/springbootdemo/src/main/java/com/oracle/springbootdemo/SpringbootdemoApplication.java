package com.oracle.springbootdemo;

import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// @EnableAutoConfiguration
// @ComponentScan(basePackages = "com.oracle.springbootdemo")
// @Configuration
@RestController
public class SpringbootdemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
		System.out.println("welcome to springboot demo application ");
	}

	// @RequestMapping(method = RequestMethod.GET, value =
	// "/welcome/{firstname}/{lastname}")
	@GetMapping("/welcome/{firstname}/{lastname}")
	public String welcome(@PathVariable("firstname") String fname, @PathVariable("lastname") String lname) {
		return "Welcome to Spring Boot Demo Application. path variable: " + fname.concat(" " + lname);
	}

	// @RequestMapping(method = RequestMethod.GET, value = "/index")
	@GetMapping("/index")
	public String index(@RequestParam("firstname") String fname, @RequestParam("lstname") String lname) {
		return "Welcome to Spring Boot Demo Application. query param: " + fname.concat(" " + lname);
	}
}
