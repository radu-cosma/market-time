package com.markettime.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public class DetailedOrderDto {

    private long id;
    private ProductDto product;
    private ShippingDto shippingInfo;
    private long transactionId;
    private Date transactionDate;
    private String transactionStatus;
    private int quantity;
    private BigDecimal shippingCost;
    private BigDecimal total;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public ShippingDto getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingDto shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DetailedOrderDto [id=").append(id).append(", product=").append(product)
                .append(", shippingInfo=").append(shippingInfo).append(", transactionId=").append(transactionId)
                .append(", transactionDate=").append(transactionDate).append(", transactionStatus=")
                .append(transactionStatus).append(", quantity=").append(quantity).append(", shippingCost=")
                .append(shippingCost).append(", total=").append(total).append("]");
        return builder.toString();
    }

}
