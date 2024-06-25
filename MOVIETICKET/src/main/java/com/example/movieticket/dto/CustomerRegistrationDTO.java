package com.example.movieticket.dto;

public class CustomerRegistrationDTO{

    private String username;
    private String password;
    private String name;
    private String phone;
    private String city;
    private boolean admin;

    // Constructors, getters, and setters

    public CustomerRegistrationDTO() {
    }

    public CustomerRegistrationDTO(String username, String password, String name, String phone, String city, boolean admin) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.admin = admin;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
