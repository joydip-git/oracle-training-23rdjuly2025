package com.oracle.basicspringapp;

//import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext container = null;
		try {
			//container will get the configuration metadata of beans from the 
			//given XML file
			container = new ClassPathXmlApplicationContext("beans.xml");
			Employee emp = (Employee) container.getBean("employeeBean");
			System.out.println(emp.getAddress().getCityName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			container = null;
		}
	}
}
