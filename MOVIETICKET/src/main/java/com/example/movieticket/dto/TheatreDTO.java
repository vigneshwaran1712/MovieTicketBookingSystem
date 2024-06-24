package com.example.movieticket.dto;

import java.util.List;

public class TheatreDTO {

    private String name;
    private String city;
    private String address;
    private List<ScreenDTO> screens;

    public TheatreDTO() {
    }

    public TheatreDTO(String name, String city,String address, List<ScreenDTO> screens) {
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

    public List<ScreenDTO> getScreens() {
        return screens;
    }

    public void setScreens(List<ScreenDTO> screens) {
        this.screens = screens;
    }
}
