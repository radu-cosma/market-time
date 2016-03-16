package com.markettime.repository;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.markettime.model.entity.UserEntity;

/**
 *
 * @author Radu Cosma
 *
 */
@Repository
public class UserRepository extends AbstractRepository<UserEntity> {

	public UserRepository() {
		super(UserEntity.class);
	}

	public UserEntity findByEmail(String email) {
		try {
			return getEntityManager().createNamedQuery(UserEntity.FIND_BY_EMAIL, UserEntity.class)
					.setParameter("email", email).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
