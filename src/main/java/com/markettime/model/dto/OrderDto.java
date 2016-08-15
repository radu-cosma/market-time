package com.markettime.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDto {

    private long id;
    private Date date;
    private String marketplace;
    private BigDecimal total;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(String marketplace) {
        this.marketplace = marketplace;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OrderDto [id=").append(id).append(", date=").append(date).append(", marketplace=")
                .append(marketplace).append(", total=").append(total).append(", status=").append(status).append("]");
        return builder.toString();
    }
}
