package com.markettime.model.dto;

public class ProductDto {

    private String name;
    private String description;
    private String tags;
    private String shipping;
    private String shippingTime;
    private String color;
    private String size;
    private String inventory;
    private String price;
    private String brand;
    private String landingPageUrl;
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

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLandingPageUrl() {
        return landingPageUrl;
    }

    public void setLandingPageUrl(String landingPageUrl) {
        this.landingPageUrl = landingPageUrl;
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
        builder.append("ProductDto [name=").append(name).append(", description=").append(description).append(", tags=")
                .append(tags).append(", shipping=").append(shipping).append(", shippingTime=").append(shippingTime)
                .append(", color=").append(color).append(", size=").append(size).append(", inventory=")
                .append(inventory).append(", price=").append(price).append(", brand=").append(brand)
                .append(", landingPageUrl=").append(landingPageUrl).append(", upc=").append(upc).append("]");
        return builder.toString();
    }

}
