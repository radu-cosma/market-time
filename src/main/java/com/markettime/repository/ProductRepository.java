package com.markettime.repository;

import org.springframework.stereotype.Repository;

import com.markettime.model.entity.ProductEntity;

/**
 *
 * @author Radu Cosma
 *
 */
@Repository
public class ProductRepository extends AbstractRepository<ProductEntity> {

    public ProductRepository() {
        super(ProductEntity.class);
    }
}
