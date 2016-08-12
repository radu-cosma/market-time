package com.markettime.repository;

import org.springframework.stereotype.Repository;

import com.markettime.model.entity.ProductImageEntity;

/**
 *
 * @author Radu Cosma
 *
 */
@Repository
public class ProductImageRepository extends AbstractRepository<ProductImageEntity> {

    public ProductImageRepository() {
        super(ProductImageEntity.class);
    }

}
