package com.markettime.model.dto.request;

import static com.markettime.util.Constants.VALIDATION_NOT_EMPTY;
import static com.markettime.util.Constants.VALIDATION_NOT_NULL;
import static com.markettime.util.Constants.VALIDATION_SIZE;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Radu Cosma
 *
 */
public class AddProductRequestDto {

    @NotEmpty(message = VALIDATION_NOT_EMPTY)
    @Size(min = 3, max = 30, message = VALIDATION_SIZE)
    private String name;

    @NotEmpty(message = VALIDATION_NOT_EMPTY)
    @Size(min = 3, max = 1000, message = VALIDATION_SIZE)
    private String description;

    @NotEmpty(message = VALIDATION_NOT_EMPTY)
    @Size(min = 3, max = 200, message = VALIDATION_SIZE)
    private String tags;

    @NotEmpty(message = VALIDATION_NOT_EMPTY)
    @Size(min = 3, max = 10, message = VALIDATION_SIZE)
    private String shipping;

    @Size(min = 3, max = 5, message = VALIDATION_SIZE)
    private String shippingTime;

    @Size(min = 3, max = 20, message = VALIDATION_SIZE)
    private String color;

    @Size(min = 1, max = 10, message = VALIDATION_SIZE)
    private String size;

    @NotNull(message = VALIDATION_NOT_NULL)
    private Integer inventory;

    @NotNull(message = VALIDATION_NOT_NULL)
    private Integer price;

    @Size(min = 3, max = 30, message = VALIDATION_SIZE)
    private String brand;

    @Size(min = 10, max = 50, message = VALIDATION_SIZE)
    private String presentationPageUrl;

    @Size(min = 12, max = 12, message = VALIDATION_SIZE)
    private String upc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(String shippingTime) {
        this.shippingTime = shippingTime;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPresentationPageUrl() {
        return presentationPageUrl;
    }

    public void setPresentationPageUrl(String presentationPageUrl) {
        this.presentationPageUrl = presentationPageUrl;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AddProductRequestDto [name=").append(name).append(", description=").append(description)
                .append(", tags=").append(tags).append(", shipping=").append(shipping).append(", shippingTime=")
                .append(shippingTime).append(", color=").append(color).append(", size=").append(size)
                .append(", inventory=").append(inventory).append(", price=").append(price).append(", brand=")
                .append(brand).append(", presentationPageUrl=").append(presentationPageUrl).append(", upc=").append(upc)
                .append("]");
        return builder.toString();
    }

}
