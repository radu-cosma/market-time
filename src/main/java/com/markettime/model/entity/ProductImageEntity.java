package com.markettime.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Radu Cosma
 *
 */
@Entity
@Table(name = "product_image")
public class ProductImageEntity {

    private Long id;
    private String name;
    private String url;
    private int weight;
    private ImageTypeEntity imageType;
    private ProductEntity product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 30, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 50, nullable = false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(nullable = false)
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @ManyToOne
    @JoinColumn(name = "image_type_id")
    public ImageTypeEntity getImageType() {
        return imageType;
    }

    public void setImageType(ImageTypeEntity imageType) {
        this.imageType = imageType;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProductImageEntity [id=").append(id).append(", name=").append(name).append(", url=").append(url)
                .append(", weight=").append(weight).append(", imageType=").append(imageType).append("]");
        return builder.toString();
    }

}
