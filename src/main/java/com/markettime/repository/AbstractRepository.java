package com.markettime.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Radu Cosma
 *
 */
public abstract class AbstractRepository<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private final Class<T> entityClass;

	public AbstractRepository(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(T entity) {
		getCurrentSession().save(entity);
	}
}
