package com.example.movieticket.model;

import javax.persistence.*;

@Entity
@Table(name = "Bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookingId")
    private Integer bookingId;

    @Column(name = "CustomerId", length = 50)
    private String customerId;

    @Column(name = "TicketsBooked", length = 200)
    private String ticketsBooked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShowId", referencedColumnName = "ShowId", insertable = true, updatable = true)
    private Show show;


    @Column(name = "Cost")
    private Integer cost;

    public Booking(int cost,String customerId,Show show) {
        this.customerId = customerId;
        this.show = show;
        this.cost = cost;
    }

    public Booking() {

    }


    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTicketsBooked() {
        return ticketsBooked;
    }

    public void setTicketsBooked(String ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}