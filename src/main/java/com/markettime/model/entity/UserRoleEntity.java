package com.markettime.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Radu Cosma
 *
 */
@Entity
@Table(name = "user_role")
@NamedQuery(name = UserRoleEntity.FIND_BY_ROLE, query = "SELECT ur FROM UserRoleEntity ur WHERE ur.role=:role")
public class UserRoleEntity {

    public static final String FIND_BY_ROLE = "UserRoleEntity.findByRole";

    private Long id;
    private UserRole role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserRoleEntity [id=").append(id).append(", role=").append(role).append("]");
        return builder.toString();
    }

}
