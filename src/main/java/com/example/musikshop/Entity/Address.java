package com.example.musikshop.Entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private int zipCode;
    private String streetName;

    public Address(String city, int zipCode, String streetName) {
        this.city = city;
        this.zipCode = zipCode;
        this.streetName = streetName;
    }

    public Address(){}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
