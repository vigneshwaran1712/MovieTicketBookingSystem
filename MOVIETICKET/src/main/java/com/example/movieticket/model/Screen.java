package com.example.movieticket.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SCREEN")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScreenId")
    private int screenId;

    @Column(name = "ScreenName", length = 50)
    private String screenName;

    @Column(name = "NoOfSeats", nullable = false)
    private int noOfSeats;


    @ManyToOne
    @JoinColumn(name = "TheatreId", referencedColumnName = "TheatreId")
    private Theatre theatre;

    // Constructors

    public Screen() {
        // Default constructor
    }

    // Getters and Setters

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
