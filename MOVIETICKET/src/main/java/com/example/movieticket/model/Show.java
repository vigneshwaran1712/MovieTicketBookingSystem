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

    // Assuming startTime is of type LocalDateTime
    @Column(name = "StartTime")
    private LocalDateTime startTime;


    @Column(name = "EndTime")
    private LocalDateTime endTime;

    @Column(name = "TicketsBooked", length = 200)
    private String ticketsBooked;


    @JoinColumns({
            @JoinColumn(name = "ScreenId", referencedColumnName = "ScreenId", insertable = false, updatable = false),
    })
    private int screenId;

    @Column(name = "MovieId")
    private Integer movieId;

}