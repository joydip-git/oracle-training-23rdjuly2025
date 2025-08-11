package com.oracle.hibernatewithspringjpa;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class ProductRepository implements RepositoryContract<Product, Integer> {

	private SessionFactory factory;
	
	public ProductRepository(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public boolean save(Product data) {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.persist(data);
			transaction.commit();
			// session.close();
			return true;
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		}
	}

	@Override
	public boolean update(Integer id, Product data) throws Exception {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Product found = session.find(Product.class, id.intValue());
			if (found != null) {
				found.setCategoryId(data.getCategoryId());
				found.setDescription(data.getDescription());
				found.setPrice(data.getPrice());
				found.setProductName(data.getProductName());
				found.setReleasedOn(data.getReleasedOn());
				// session.merge(found);
				transaction.commit();
				return true;
			} else
				throw new Exception("product with id " + id + " not found");
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		}
	}

	@Override
	public boolean delete(Integer id) throws Exception {
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Product found = session.find(Product.class, id.intValue());
			if (found != null) {
				session.remove(found);
				transaction.commit();
				return true;
			} else
				throw new Exception("product with id " + id + " not found");
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		}
	}

	@Override
	public List<Product> getAll() {
		try (Session session = factory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> query = builder.createQuery(Product.class);
			query.from(Product.class);			
			List<Product> products = session.createQuery(query).getResultList();
			return products;
		} catch (HibernateException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Product get(Integer id) throws Exception {
		try (Session session = factory.openSession()) {
			Product found = session.find(Product.class, id.intValue());
			if (found != null) {
				return found;
			} else
				throw new Exception("product with id " + id + " not found");
		} catch (HibernateException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
}
