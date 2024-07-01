package com.example.movieticket.repository;

import com.example.movieticket.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query("SELECT booking.ticketsBooked FROM Booking booking WHERE booking.bookingId = :bookingId")
    String findTicketsBookedByBookingId(@Param("bookingId") Integer bookingId);

    @Query("SELECT booking.show.showId FROM Booking booking WHERE booking.bookingId =:bookingId")
    int findShowIdByBookingId(@Param("bookingId") Integer bookingId);

    @Transactional
    @Modifying
    @Query("UPDATE Booking s SET s.ticketsBooked = :seats WHERE s.bookingId =:bookingId")
    void updateSeatsByBookingId(@Param("bookingId") Integer bookingId, @Param("seats") String seats);



    @Query("SELECT b.bookingId, m.movieName, t.name, s.startTime, b.cost, b.ticketsBooked " +
            "FROM Booking b " +
            "JOIN b.show s " +
            "JOIN Movie m ON s.movieId = m.movieId " +
            "JOIN Screen sc ON s.ScreenId = sc.screenId " +
            "JOIN Theatre t ON sc.theatre.theatreId = t.theatreId " +
            "WHERE b.customerId = :customerId AND s.startTime< :currentTime")
    List<Object[]> findCustomerBookingsBeforeCurrentDate(
            @Param("customerId") String customerId,
            @Param("currentTime") LocalDateTime currentTime);

    @Query("SELECT b.bookingId, m.movieName, t.name, s.startTime, b.cost, b.ticketsBooked " +
            "FROM Booking b " +
            "JOIN b.show s " +
            "JOIN Movie m ON s.movieId = m.movieId " +
            "JOIN Screen sc ON s.ScreenId = sc.screenId " +
            "JOIN Theatre t ON sc.theatre.theatreId = t.theatreId " +
            "WHERE b.customerId = :customerId AND s.startTime> :currentTime")
    List<Object[]> findCustomerBookingsAfterCurrentDate(
            @Param("customerId") String customerId,
            @Param("currentTime") LocalDateTime currentTime);
}
