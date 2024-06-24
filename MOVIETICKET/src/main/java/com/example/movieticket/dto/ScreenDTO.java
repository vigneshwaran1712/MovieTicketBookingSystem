package com.example.movieticket.dto;

public class ScreenDTO {

    private String name;
    private int no_of_seats;

    public ScreenDTO() {
    }

    public ScreenDTO(String name, int no_of_seats) {
        this.name = name;
        this.no_of_seats = no_of_seats;
    }

    public int getNo_of_seats() {
        return no_of_seats;
    }

    public void setNo_of_seats(int no_of_seats) {
        this.no_of_seats = no_of_seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
