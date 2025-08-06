package com.oracle.beansconfig_code;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	ApplicationContext container = null;

		try {
			container = new AnnotationConfigApplicationContext(BeanConfiguration.class);
			DataManager manager = container.getBean(DataManager.class);
			System.out.println(manager.fetchData());
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
