package com.markettime.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Radu Cosma
 *
 */
@Entity
@Table(name = "product")
public class ProductEntity {

    private Long id;
    private String name;
    private String description;
    private String shipping;
    private String shippingTime;
    private String color;
    private String size;
    private int inventory;
    private int price;
    private String brand;
    private String presentationPageUrl;
    private String upc;
    private UserEntity user;
    private List<ProductTagEntity> productTags;
    private List<ProductImageEntity> productImages;

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

    @Column(length = 1000, nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(length = 10, nullable = false)
    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    @Column(name = "shipping_time", length = 5)
    public String getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(String shippingTime) {
        this.shippingTime = shippingTime;
    }

    @Column(length = 20)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(length = 10)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Column(nullable = false)
    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Column(nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(length = 30)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "presentation_page_url", length = 50)
    public String getPresentationPageUrl() {
        return presentationPageUrl;
    }

    public void setPresentationPageUrl(String presentationPageUrl) {
        this.presentationPageUrl = presentationPageUrl;
    }

    @Column(length = 12)
    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "product")
    public List<ProductTagEntity> getProductTags() {
        return productTags;
    }

    public void setProductTags(List<ProductTagEntity> productTags) {
        this.productTags = productTags;
    }

    @OneToMany(mappedBy = "product")
    public List<ProductImageEntity> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImageEntity> productImages) {
        this.productImages = productImages;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProductEntity [id=").append(id).append(", name=").append(name).append(", description=")
                .append(description).append(", shipping=").append(shipping).append(", shippingTime=")
                .append(shippingTime).append(", color=").append(color).append(", size=").append(size)
                .append(", inventory=").append(inventory).append(", price=").append(price).append(", brand=")
                .append(brand).append(", presentationPageUrl=").append(presentationPageUrl).append(", upc=").append(upc)
                .append(", user=").append(user).append("]");
        return builder.toString();
    }

}
