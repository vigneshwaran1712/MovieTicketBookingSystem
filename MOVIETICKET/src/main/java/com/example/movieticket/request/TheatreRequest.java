package com.example.movieticket.request;

import java.util.List;

public class TheatreRequest {

    private String name;
    private String city;
    private String address;
    private List<ScreenRequest> screens;

    public TheatreRequest() {
    }

    public TheatreRequest(String name, String city,String address, List<ScreenRequest> screens) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.screens = screens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public List<ScreenRequest> getScreens() {
        return screens;
    }

    public void setScreens(List<ScreenRequest> screens) {
        this.screens = screens;
    }
}
