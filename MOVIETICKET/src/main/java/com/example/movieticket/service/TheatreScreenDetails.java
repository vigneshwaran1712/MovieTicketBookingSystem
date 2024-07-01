package com.example.movieticket.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TheatreScreenDetails {
    @JsonProperty("theatreId")
    private Integer theatreId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;

    @JsonProperty("screenNames")
    private List<String> screenNames;

    // Constructor
    public TheatreScreenDetails(Integer theatreId, String name, String address, String city, List<String> screenNames) {
        this.theatreId = theatreId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.screenNames = screenNames;
    }

    // Getters and Setters (if needed)
    public Integer getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Integer theatreId) {
        this.theatreId = theatreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getScreenNames() {
        return screenNames;
    }

    public void setScreenNames(List<String> screenNames) {
        this.screenNames = screenNames;
    }
}
