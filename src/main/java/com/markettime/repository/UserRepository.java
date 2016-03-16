package com.markettime.repository;

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
		return null;
	}

}
