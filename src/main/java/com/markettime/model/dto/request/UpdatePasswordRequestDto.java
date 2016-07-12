package com.markettime.model.dto.request;

/**
 *
 * @author Radu Cosma
 *
 */
public class UpdatePasswordRequestDto {

    private String passwordCurrentPassword;
    private String newPassword;
    private String confirmPassword;

    public String getPasswordCurrentPassword() {
        return passwordCurrentPassword;
    }

    public void setPasswordCurrentPassword(String passwordCurrentPassword) {
        this.passwordCurrentPassword = passwordCurrentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UpdatePasswordRequestDto [passwordCurrentPassword=").append(passwordCurrentPassword)
                .append(", newPassword=").append(newPassword).append(", confirmPassword=").append(confirmPassword)
                .append("]");
        return builder.toString();
    }

}
