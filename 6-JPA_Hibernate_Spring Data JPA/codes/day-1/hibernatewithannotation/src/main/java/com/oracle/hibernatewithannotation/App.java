package com.oracle.hibernatewithannotation;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;

		StandardServiceRegistry registry = null;
		MetadataSources sources = null;
		Metadata metadata = null;

		try {
			// configuring a registry to read configuration data of Session factory from an
			// XML file in a type-safer manner
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();

			// to Read setting information from an XML file using the standard resource
			// location.
			builder.configure();

			// builds a registry instance with the given configuration
			registry = builder.build();

			// Loading metadata from the given registry
			sources = new MetadataSources(registry);

			// creating an instance of Metadata holding the metadata for Hibernate
			// configuration
			metadata = sources.buildMetadata();

			// create an instance of factory using the metadata instance
			factory = metadata.buildSessionFactory();

			// creating a session
			session = factory.openSession();

			// initiating a transaction
			transaction = session.beginTransaction();

			Product newProduct = new Product(106, "one plus 13", "new mobile from one plus", 
					56000,Date.valueOf(LocalDate.now()), 1);
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
