package com.markettime.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Radu Cosma
 *
 */
public abstract class AbstractRepository<T> {

	@PersistenceContext
	private EntityManager entityManager;

	private final Class<T> entityClass;

	public AbstractRepository(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public void persist(T entity) {
		getEntityManager().persist(entity);
	}

	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}

}
