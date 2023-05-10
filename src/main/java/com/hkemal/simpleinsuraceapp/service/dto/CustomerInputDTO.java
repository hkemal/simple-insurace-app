package com.hkemal.simpleinsuraceapp.service.dto;

import java.io.Serializable;

public class CustomerInputDTO implements Serializable {

    private String firstName;

    private String lastName;

    private String citizenshipNumber;

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

    public String getCitizenshipNumber() {
        return citizenshipNumber;
    }

    public void setCitizenshipNumber(String citizenshipNumber) {
        this.citizenshipNumber = citizenshipNumber;
    }
}
