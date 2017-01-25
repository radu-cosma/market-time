package com.markettime.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Radu Cosma
 *
 */
@Entity
@Table(name = "image_type")
@NamedQueries(value = {
        @NamedQuery(name = ImageTypeEntity.FIND_BY_TYPE, query = "SELECT it FROM ImageTypeEntity it WHERE it.type=:type"),
        @NamedQuery(name = ImageTypeEntity.FIND_ALL, query = "SELECT it FROM ImageTypeEntity it") })
public class ImageTypeEntity {

    public static final String FIND_BY_TYPE = "ImageTypeEntity.findByType";
    public static final String FIND_ALL = "ImageTypeEntity.findAll";

    private Long id;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ImageTypeEntity [id=").append(id).append(", type=").append(type).append("]");
        return builder.toString();
    }

}
