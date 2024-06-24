package com.example.movieticket.dto;

import java.util.List;

public class AdminDTO {

    private String name;
    private String email;
    private String password;
    private List<TheatreDTO> theatres;
    private List<ScreenDTO> screens;


    public AdminDTO() {
    }

    public AdminDTO(String name, String email, String password, List<TheatreDTO> theatres, List<ScreenDTO> screens) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.theatres = theatres;
        this.screens = screens;
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
        System.out.println(theatres);
        return theatres;
    }

    public void setTheatres(List<TheatreDTO> theatres) {
        this.theatres = theatres;
    }

    public List<ScreenDTO> getScreens() {
        return screens;
    }

    public void setScreens(List<ScreenDTO> screens) {
        this.screens = screens;
    }
}
