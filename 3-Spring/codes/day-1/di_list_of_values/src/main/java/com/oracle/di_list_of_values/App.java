package com.oracle.di_list_of_values;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext container = null;

		try {
			container = new ClassPathXmlApplicationContext("beans.xml");
			StudentList listOfStudents = container.getBean("studentListBean", StudentList.class);
			if (listOfStudents != null) {
				List<Student> students = listOfStudents.getStudents();
				if (students != null && students.size() > 0)
					students
						.stream()
						.forEach((s) -> System.out.println(s.getName()));
				else
					System.out.println("collection is either null or empty");
			} else
				System.out.println("could not instantiate");
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
