package com.markettime.model.dto.request;

/**
 *
 * @author Radu Cosma
 *
 */
public class UpdateEmailRequestDto {

    private String email;
    private String confirmEmail;
    private String emailCurrentPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public String getEmailCurrentPassword() {
        return emailCurrentPassword;
    }

    public void setEmailCurrentPassword(String emailCurrentPassword) {
        this.emailCurrentPassword = emailCurrentPassword;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UpdateEmailRequestDto [email=").append(email).append(", confirmEmail=").append(confirmEmail)
                .append(", emailCurrentPassword=").append(emailCurrentPassword).append("]");
        return builder.toString();
    }

}
