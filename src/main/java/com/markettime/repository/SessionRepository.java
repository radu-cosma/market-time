package com.markettime.repository;

import org.springframework.stereotype.Repository;

import com.markettime.model.entity.SessionEntity;

/**
 *
 * @author Radu Cosma
 *
 */
@Repository
public class SessionRepository extends AbstractRepository<SessionEntity> {

	public SessionRepository() {
		super(SessionEntity.class);
	}

}
