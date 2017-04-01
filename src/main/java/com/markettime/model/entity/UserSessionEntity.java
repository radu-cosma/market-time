package com.markettime.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Radu Cosma
 *
 */
@Entity
@Table(name = "user_session", uniqueConstraints = { @UniqueConstraint(columnNames = "uuid") })
@NamedQueries(value = {
        @NamedQuery(name = UserSessionEntity.FIND_ACTIVE_BY_UUID, query = "SELECT us FROM UserSessionEntity us WHERE us.uuid=:uuid AND us.active=true"),
        @NamedQuery(name = UserSessionEntity.FIND_ACTIVE_BY_USER_ID, query = "SELECT us FROM UserSessionEntity us WHERE us.user.id=:userId AND us.active=true") })
public class UserSessionEntity {

    public static final String FIND_ACTIVE_BY_UUID = "UserSessionEntity.findActiveByUuid";
    public static final String FIND_ACTIVE_BY_USER_ID = "UserSessionEntity.findActiveByUserId";

    private Long id;
    private UserEntity user;
    private String uuid;
    private boolean active;
    private Date creationTime;
    private Date lastAccess;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Column(length = 36, nullable = false)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Column(nullable = false)
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_time", nullable = false)
    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_access", nullable = false)
    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SessionEntity [id=").append(id).append(", user=").append(user).append(", uuid=").append(uuid)
                .append(", active=").append(active).append(", creationTime=").append(creationTime)
                .append(", lastAccess=").append(lastAccess).append("]");
        return builder.toString();
    }

}
