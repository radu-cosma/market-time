package com.markettime.model.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.markettime.validator.RegistrationValid;

/**
 *
 * @author Radu Cosma
 *
 */
@RegistrationValid
public class RegistrationDto {

    @NotEmpty
    @Size(max = 30)
    private String firstName;

    @NotEmpty
    @Size(max = 30)
    private String lastName;

    @NotEmpty
    @Size(max = 127)
    private String email;

    @Size(min = 8, max = 63)
    private String password;

    @Size(min = 8, max = 63)
    private String repeatPassword;

    @NotEmpty
    @Size(max = 30)
    private String companyName;

    @NotEmpty
    @Size(max = 100)
    private String companyAddress;

    @NotEmpty
    @Size(max = 15)
    private String companyPhone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RegistrationDto [firstName=").append(firstName).append(", lastName=").append(lastName)
                .append(", email=").append(email).append(", password=").append(password).append(", repeatPassword=")
                .append(repeatPassword).append(", companyName=").append(companyName).append(", companyAddress=")
                .append(companyAddress).append(", companyPhone=").append(companyPhone).append("]");
        return builder.toString();
    }

}
