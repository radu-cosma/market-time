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

	/**
	 *
	 * @param entity
	 */
	public void persist(T entity) {
		getEntityManager().persist(entity);
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}

	/**
	 *
	 * @param entity
	 */
	public void merge(T entity) {
		getEntityManager().merge(entity);
	}

	/**
	 *
	 * @param entity
	 */
	public void remove(T entity) {
		getEntityManager().remove(entity);
	}

}
