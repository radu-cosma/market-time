package com.markettime.repository;

import org.springframework.stereotype.Repository;

import com.markettime.model.entity.CompanyEntity;

/**
 *
 * @author Radu Cosma
 *
 */
@Repository
public class CompanyRepository extends AbstractRepository<CompanyEntity> {

	public CompanyRepository() {
		super(CompanyEntity.class);
	}

}
