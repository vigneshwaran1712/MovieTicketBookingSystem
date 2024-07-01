package com.example.movieticket.dto;

import java.util.List;

public class AdminDTO {

    private String name;
    private String email;
    private String password;
    private List<TheatreDTO> theatres;
    private String phone;
    private String city;
    private Boolean admin;


    public AdminDTO() {
    }

    public AdminDTO(String name, String email, String password,String phone,String city, boolean admin, List<TheatreDTO> theatres) {
        this.name = name;
        this.city = city;
        this.phone = phone;
        this.admin = admin;
        this.email = email;
        this.password = password;
        this.theatres = theatres;
    }
    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getCity(){
        return this.city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public Boolean getAdmin(){
        return this.admin;
    }
    public void setAdmin(Boolean isAdmin){
        this.admin = isAdmin;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<TheatreDTO> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<TheatreDTO> theatres) {
        this.theatres = theatres;
    }
}
