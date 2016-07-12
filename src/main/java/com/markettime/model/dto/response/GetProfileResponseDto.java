package com.markettime.model.dto.response;

import org.dozer.Mapping;

/**
 *
 * @author Radu Cosma
 *
 */
public class GetProfileResponseDto {

    private String firstName;

    private String lastName;

    @Mapping("company.name")
    private String companyName;

    @Mapping("company.address")
    private String companyAddress;

    @Mapping("company.phone")
    private String companyPhone;

    private String email;

    private String password;

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
        builder.append("GetProfileResponseDto [firstName=").append(firstName).append(", lastName=").append(lastName)
                .append(", companyName=").append(companyName).append(", companyAddress=").append(companyAddress)
                .append(", companyPhone=").append(companyPhone).append(", email=").append(email).append(", password=")
                .append(password).append("]");
        return builder.toString();
    }

}
