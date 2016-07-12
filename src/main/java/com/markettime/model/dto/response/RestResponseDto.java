package com.markettime.model.dto.response;

import java.util.Map;

/**
 *
 * @author Radu Cosma
 *
 */
public class RestResponseDto {

    private String generalError;
    private Map<String, String> validationErrors;
    private Object result;

    public String getGeneralError() {
        return generalError;
    }

    public void setGeneralError(String generalError) {
        this.generalError = generalError;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RestResponseDto [generalError=").append(generalError).append(", validationErrors=")
                .append(validationErrors).append(", result=").append(result).append("]");
        return builder.toString();
    }

}
