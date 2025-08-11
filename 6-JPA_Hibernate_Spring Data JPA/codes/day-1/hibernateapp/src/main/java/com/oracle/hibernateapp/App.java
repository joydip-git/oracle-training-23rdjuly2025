package com.oracle.hibernateapp;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		Configuration configuration = null;
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;

		try {
			configuration = new Configuration();
			// by default it should find the "hibernate.cfg.xml" file from class path
			configuration.configure();

			factory = configuration.buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();

			Product newProduct = new Product(105, "one plus 13", "new mobile from one plus", 56000,
					Date.valueOf(LocalDate.now()), 1);
			session.persist(newProduct);

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
