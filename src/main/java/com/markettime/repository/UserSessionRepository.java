package com.markettime.repository;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.markettime.model.entity.UserSessionEntity;

/**
 *
 * @author Radu Cosma
 *
 */
@Repository
public class UserSessionRepository extends AbstractRepository<UserSessionEntity> {

    public UserSessionRepository() {
        super(UserSessionEntity.class);
    }

    /**
     *
     * @param uuid
     * @return
     */
    public UserSessionEntity findActive(String uuid) {
        try {
            return getEntityManager().createNamedQuery(UserSessionEntity.FIND_ACTIVE_BY_UUID, UserSessionEntity.class)
                    .setParameter("uuid", uuid).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
