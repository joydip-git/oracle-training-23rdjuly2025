package com.oracle.hibernatewithspringjpa;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beansconfig.xml")) {
			RepositoryContract<Product, Integer> dao = context.getBean("repoBean", ProductRepository.class);
			List<Product> products = dao.getAll();
			if (products != null && products.size() > 0) {
				products.stream().forEach((p) -> System.out.println(p.getProductName()));
			} else
				System.out.println("product not found...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
