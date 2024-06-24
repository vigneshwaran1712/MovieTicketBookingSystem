package com.example.movieticket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    private String actor;
    private String actress;
    private String director;
    private Integer length;
    private Integer ticketPrice;
    private String genre;
    private String imageUrl;

    // Constructors, getters, and setters

    public Movie() {
        // Default constructor required by JPA
    }

    public Movie(String actor, String actress, String director, Integer length, Integer ticketPrice, String genre, String imageUrl) {
        this.actor = actor;
        this.actress = actress;
        this.director = director;
        this.length = length;
        this.ticketPrice = ticketPrice;
        this.genre = genre;
    }


}