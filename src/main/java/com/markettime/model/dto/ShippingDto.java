package com.markettime.model.dto;

public class ShippingDto {

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ShippingDto [firstName=").append(firstName).append(", lastName=").append(lastName)
                .append(", address=").append(address).append(", email=").append(email).append(", phoneNumber=")
                .append(phoneNumber).append("]");
        return builder.toString();
    }

}
