package com.markettime.model.dto.request;

import static com.markettime.util.Constants.VALIDATION_NOT_EMPTY;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Radu Cosma
 *
 */
public class AddProductImageDto {

    @NotEmpty(message = VALIDATION_NOT_EMPTY)
    private String name;
    @NotEmpty(message = VALIDATION_NOT_EMPTY)
    private String type;
    private int weight;
    private String url;
    private byte[] imageData;
    @NotEmpty(message = VALIDATION_NOT_EMPTY)
    private String addProductSessionId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getAddProductSessionId() {
        return addProductSessionId;
    }

    public void setAddProductSessionId(String addProductSessionId) {
        this.addProductSessionId = addProductSessionId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AddProductImageDto [name=").append(name).append(", type=").append(type).append(", weight=")
                .append(weight).append(", url=").append(url).append(", addProductSessionId=")
                .append(addProductSessionId).append("]");
        return builder.toString();
    }

}
