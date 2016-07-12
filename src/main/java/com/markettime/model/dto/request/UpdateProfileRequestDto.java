package com.markettime.model.dto.request;

import static com.markettime.util.Constants.VALIDATION_PATTERN;
import static com.markettime.util.Constants.VALIDATION_SIZE;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.dozer.Mapping;

/**
 *
 * @author Radu Cosma
 *
 */
public class UpdateProfileRequestDto {

    @Size(min = 3, max = 30, message = VALIDATION_SIZE)
    private String firstName;

    @Size(min = 3, max = 30, message = VALIDATION_SIZE)
    private String lastName;

    @Mapping("company.name")
    @Size(min = 3, max = 30, message = VALIDATION_SIZE)
    private String companyName;

    @Mapping("company.address")
    @Size(min = 3, max = 100, message = VALIDATION_SIZE)
    private String companyAddress;

    @Mapping("company.phone")
    @Size(min = 10, max = 15, message = VALIDATION_SIZE)
    @Pattern(regexp = "^[0-9 \\+\\-\\(\\)]+$", message = VALIDATION_PATTERN)
    private String companyPhone;

    @Size(min = 8, max = 63, message = VALIDATION_SIZE)
    @Pattern(regexp = "^[a-zA-Z0-9!\\(\\)\\*\\+,\\-\\/\\.:;=@\\[\\]\\_\\{\\}\\\\?!]+$", message = VALIDATION_PATTERN)
    private String profileCurrentPassword;

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

    public String getProfileCurrentPassword() {
        return profileCurrentPassword;
    }

    public void setProfileCurrentPassword(String profileCurrentPassword) {
        this.profileCurrentPassword = profileCurrentPassword;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UpdateProfileRequestDto [firstName=").append(firstName).append(", lastName=").append(lastName)
                .append(", companyName=").append(companyName).append(", companyAddress=").append(companyAddress)
                .append(", companyPhone=").append(companyPhone).append(", profileCurrentPassword=")
                .append(profileCurrentPassword).append("]");
        return builder.toString();
    }

}
