package com.example.movieticket.dto;

public class ScreenDTO {

    private String name;
    private int seats;

    public ScreenDTO() {
    }

    public ScreenDTO(String name, int seats) {
        this.name = name;
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setNo_of_seats(int no_of_seats) {
        this.seats = no_of_seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
