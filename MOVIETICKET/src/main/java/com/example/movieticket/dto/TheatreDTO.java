package com.example.movieticket.dto;

import java.util.List;

public class TheatreDTO {


    private String name;
    private String city;
    private String address;
    private int screens;
    private List<ScreenDTO> screen_details;

    public TheatreDTO() {
    }

    public TheatreDTO(String name,String screens, String city, String address, List<ScreenDTO> screen_details) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.screens = Integer.parseInt(screens);
        this.screen_details = screen_details;
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

    public int getScreens() {
        return screens;
    }

    public void setScreen_details(List<ScreenDTO> screen_details) {
        this.screen_details = screen_details;
    }

    public List<ScreenDTO> getScreen_details() {
        return screen_details;
    }

    public void setScreens(int screens) {
        this.screens = screens;
    }
}
