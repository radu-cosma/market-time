package com.markettime.model.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Radu Cosma
 *
 */
public class LoginDto {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LoginDto [email=").append(email).append(", password=").append(password).append("]");
        return builder.toString();
    }

}
