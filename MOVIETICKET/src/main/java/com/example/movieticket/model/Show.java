package com.example.movieticket.model;

import javax.persistence.*;

@Entity
@Table(name = "SHOW")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShowId")
    private Integer showId;

    @Column(name = "StartTime", length = 30)
    private String startTime;

    @Column(name = "EndTime", length = 30)
    private String endTime;

    @Column(name = "TicketsBooked", length = 200)
    private String ticketsBooked;


    @JoinColumns({
            @JoinColumn(name = "ScreenId", referencedColumnName = "ScreenId", insertable = false, updatable = false),
    })
    private int screenId;

    @Column(name = "MovieId")
    private Integer movieId;

}