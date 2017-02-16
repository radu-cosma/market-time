package com.markettime.service.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.markettime.model.dto.request.AddProductImageDto;

/**
 *
 * @author Radu Cosma
 *
 */
public class ProductImagesList {

    private List<AddProductImageDto> productImages;
    private Date lastAccess;

    public ProductImagesList() {
        productImages = new ArrayList<>();
        lastAccess = new Date();
    }

    public List<AddProductImageDto> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<AddProductImageDto> productImages) {
        this.productImages = productImages;
    }

    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProductImagesList [productImages=").append(productImages).append(", lastAccess=")
                .append(lastAccess).append("]");
        return builder.toString();
    }

}
