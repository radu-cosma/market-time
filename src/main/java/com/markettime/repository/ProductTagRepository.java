package com.markettime.repository;

import org.springframework.stereotype.Repository;

import com.markettime.model.entity.ProductTagEntity;

/**
 *
 * @author Radu Cosma
 *
 */
@Repository
public class ProductTagRepository extends AbstractRepository<ProductTagEntity> {

    public ProductTagRepository() {
        super(ProductTagEntity.class);
    }
}
