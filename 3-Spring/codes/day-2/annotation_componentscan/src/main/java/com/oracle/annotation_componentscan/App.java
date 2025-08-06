package com.oracle.annotation_componentscan;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext container = null;

		try {
			container = new ClassPathXmlApplicationContext("beans.xml");
			DataManager manager = container.getBean(DataManager.class);
			System.out.println(manager.fetchData());
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
