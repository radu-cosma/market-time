package com.markettime.model.dto.request;

import static com.markettime.util.Constants.VALIDATION_MIN;
import static com.markettime.util.Constants.VALIDATION_NOT_EMPTY;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Radu Cosma
 *
 */
public class RemoveProductImageDto {

    @Min(value = 1, message = VALIDATION_MIN)
    private int weight;
    @NotEmpty(message = VALIDATION_NOT_EMPTY)
    private String addProductSessionId;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
        builder.append("RemoveProductImageDto [weight=").append(weight).append(", addProductSessionId=")
                .append(addProductSessionId).append("]");
        return builder.toString();
    }

}
