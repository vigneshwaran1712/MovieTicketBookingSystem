package com.example.movieticket.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SHOW")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShowId")
    private Integer showId;


    @Column(name = "ScreenId")
    private int ScreenId;

    @Column(name = "StartTime")
    private LocalDateTime startTime;

    @Column(name = "EndTime")
    private LocalDateTime endTime;

    @Column(name = "TicketsBooked")
    private Integer ticketsBooked;

    @Column(name = "Seats")
    private String seats;

    @Column(name = "MovieId")
    private Integer movieId;

    // Constructors, getters, and setters

    public Show() {
        // Default constructor
    }

    public Integer getShowId() {
        return showId;
    }

    public void setScreenId(int ScreenId) {
        this.ScreenId = ScreenId;
    }
    public int getScreenId() {
        return ScreenId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getTicketsBooked() {
        return ticketsBooked;
    }

    public void setTicketsBooked(Integer ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
}
