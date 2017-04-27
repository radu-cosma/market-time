package com.markettime.repository;

import org.springframework.stereotype.Repository;

import com.markettime.model.entity.UserRole;
import com.markettime.model.entity.UserRoleEntity;

/**
 *
 * @author Radu Cosma
 *
 */
@Repository
public class UserRoleRepository extends AbstractRepository<UserRoleEntity> {

    public UserRoleRepository() {
        super(UserRoleEntity.class);
    }

    /**
     *
     * @param userRole
     * @return
     */
    public UserRoleEntity findByRole(UserRole userRole) {
        return getEntityManager().createNamedQuery(UserRoleEntity.FIND_BY_ROLE, UserRoleEntity.class)
                .setParameter("role", userRole).getSingleResult();
    }
}
