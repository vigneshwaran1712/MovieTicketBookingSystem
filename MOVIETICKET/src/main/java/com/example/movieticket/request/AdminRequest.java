package com.example.movieticket.request;

import java.util.List;

public class AdminRequest {

    private String name;
    private String email;
    private String password;
    private List<TheatreRequest> theatres;
    private List<ScreenRequest> screens;


    public AdminRequest() {
    }

    public AdminRequest(String name, String email, String password, List<TheatreRequest> theatres, List<ScreenRequest> screens) {
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

    public List<TheatreRequest> getTheatres() {
        System.out.println(theatres);
        return theatres;
    }

    public void setTheatres(List<TheatreRequest> theatres) {
        this.theatres = theatres;
    }

    public List<ScreenRequest> getScreens() {
        return screens;
    }

    public void setScreens(List<ScreenRequest> screens) {
        this.screens = screens;
    }
}
