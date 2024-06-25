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
    private String movieName;
    private String actress;
    private String director;
    private Integer length;
    private Integer ticketPrice;
    private String genre;
    private String imageUrl;

    // Constructors, getters, and setters

    public Movie() {
    }

    public Movie(String actor,String movieName, String actress, String director, Integer length, Integer ticketPrice, String genre, String imageUrl) {
        this.actor = actor;
        this.actress = actress;
        this.director = director;
        this.length = length;
        this.ticketPrice = ticketPrice;
        this.genre = genre;
        this.imageUrl = imageUrl;
        this.movieName = movieName;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActress() {
        return actress;
    }

    public void setActress(String actress) {
        this.actress = actress;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLength() {
        return String.valueOf(length);
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

}