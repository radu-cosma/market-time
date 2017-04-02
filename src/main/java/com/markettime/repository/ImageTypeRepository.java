package com.markettime.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.markettime.model.entity.ImageTypeEntity;

/**
 *
 * @author Radu Cosma
 *
 */
@Repository
public class ImageTypeRepository extends AbstractRepository<ImageTypeEntity> {

    public ImageTypeRepository() {
        super(ImageTypeEntity.class);
    }

    /**
     *
     * @param type
     * @return
     */
    public ImageTypeEntity findByType(String type) {
        return getEntityManager().createNamedQuery(ImageTypeEntity.FIND_BY_TYPE, ImageTypeEntity.class)
                .setParameter("type", type).getSingleResult();
    }

    /**
     *
     * @return
     */
    public List<ImageTypeEntity> findAll() {
        return getEntityManager().createNamedQuery(ImageTypeEntity.FIND_ALL, ImageTypeEntity.class).getResultList();
    }
}
