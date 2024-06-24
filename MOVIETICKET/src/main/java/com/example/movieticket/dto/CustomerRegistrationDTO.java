package com.example.movieticket.dto;

public class CustomerRegistrationDTO {
    private String email;
    private String password;
    private boolean admin;
    private String name;
    private String phone;
    private String city;

    // Constructors, getters, and setters
    public CustomerRegistrationDTO() {}

    public CustomerRegistrationDTO(String email, String password, boolean admin, String name, String phone, String city) {
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.name = name;
        this.phone = phone;
        this.city = city;
    }

    // Getters and setters
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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
}
