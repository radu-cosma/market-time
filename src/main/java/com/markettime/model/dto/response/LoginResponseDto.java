package com.markettime.model.dto.response;

public class LoginResponseDto {

    private boolean loggedIn;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LoginResponseDto [loggedIn=").append(loggedIn).append("]");
        return builder.toString();
    }
}
