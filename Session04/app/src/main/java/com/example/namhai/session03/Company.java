package com.example.namhai.session03;

/**
 * Created by Nam Hai on 9/21/2016.
 */
public class Company {
    String name;
    String website;
    String phone;

    public Company(String name, String website, String phone) {
        this.name = name;
        this.website = website;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
