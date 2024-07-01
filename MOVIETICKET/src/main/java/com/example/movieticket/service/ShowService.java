package com.example.movieticket.service;

import com.example.movieticket.model.Booking;
import com.example.movieticket.model.Show;
import com.example.movieticket.repository.BookingRepository;
import com.example.movieticket.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class ShowService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowRepository showRepository;

    public List<Show> getShowsByMovieIdAndTheatreIdAfterCurrentTime(int movieId, List<Integer> screenIds){
        LocalDateTime currentTime = LocalDateTime.now();
        return showRepository.findShowsByMovieIdAndScreenIdsAfterCurrentTime(movieId,screenIds,currentTime);
    }

    public List<Show> getShowsByShowId(int showId){
        return showRepository.findShowsByShowId(showId);
    }
//    public String getSeatsByShowId(int showId) {
//        return
//    }
    public String getSeatsByShowId(int showId){
        return showRepository.findSeatByShowId(showId);
    }
    public String bookSeats(int showId, int cost, List<Integer> seats) {
        String seatsString = "";
        for (int i = 0; i < seats.size(); i++) {
            seatsString = seatsString + " " + seats.get(i);
        }
        String seatsShow = showRepository.findSeatByShowId(showId);
        String tempString = "";
        System.out.println(seatsShow);
        for (int i = 0; i < seatsShow.length(); i++) {
            if (seats.contains(i + 1)) {

                if (seatsShow.charAt(i) == 'B') {
                    return "Seats Not Booked";
                } else {
                    tempString = tempString + "B";
                }
            } else {
                tempString += seatsShow.charAt(i);
            }
        }
        Show show = showRepository.findById(showId).orElseThrow(() -> new RuntimeException("Show not found"));
        String customerId = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(show.getShowId());
        Booking booking = new Booking(cost, customerId, show);
        booking.setTicketsBooked(seatsString);
        System.out.println(booking.getShow().getShowId());
        bookingRepository.save(booking);
        showRepository.updateSeatsByShowId(showId, tempString);
        return "Seats Booked Successfully";


    }

}
