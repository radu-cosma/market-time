package com.markettime.model.dto.response;

import java.util.Map;

public class LoginResponseDto {

    private boolean loggedIn;
    private String generalError;
    private Map<String, String> validationErrors;

    public String getGeneralError() {
        return generalError;
    }

    public void setGeneralError(String generalError) {
        this.generalError = generalError;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LoginResponseDto [loggedIn=").append(loggedIn).append(", generalError=").append(generalError)
                .append(", validationErrors=").append(validationErrors).append("]");
        return builder.toString();
    }
}
