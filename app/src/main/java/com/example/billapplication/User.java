package com.example.billapplication;

public class User {
    private int id;
    private String Contact_No,username,password, Shop_Name,address,Registration_No,License_No,
            GST_No,Email,Contact_person;
    public User(int id, String contact_No, String username, String password, String shop_Name, String address, String registration_No, String license_No, String GST_No, String email, String contact_person) {
        this.id = id;
        Contact_No = contact_No;
        this.username = username;
        this.password = password;
        Shop_Name = shop_Name;
        this.address = address;
        Registration_No = registration_No;
        License_No = license_No;
        this.GST_No = GST_No;
        Email = email;
        Contact_person = contact_person;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContact_No() {
        return Contact_No;
    }

    public void setContact_No(String contact_No) {
        Contact_No = contact_No;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShop_Name() {
        return Shop_Name;
    }

    public void setShop_Name(String shop_Name) {
        Shop_Name = shop_Name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegistration_No() {
        return Registration_No;
    }

    public void setRegistration_No(String registration_No) {
        Registration_No = registration_No;
    }

    public String getLicense_No() {
        return License_No;
    }

    public void setLicense_No(String license_No) {
        License_No = license_No;
    }

    public String getGST_No() {
        return GST_No;
    }

    public void setGST_No(String GST_No) {
        this.GST_No = GST_No;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContact_person() {
        return Contact_person;
    }

    public void setContact_person(String contact_person) {
        Contact_person = contact_person;
    }




}
