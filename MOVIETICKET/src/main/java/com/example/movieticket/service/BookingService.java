package com.example.movieticket.service;

import com.example.movieticket.repository.BookingRepository;
import com.example.movieticket.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowService showService;

    @Autowired
    private ShowRepository showRepository;

    public String partialCancel(int bookingId, List<Integer> cancelSeats) {
        String bookedSeats = bookingRepository.findTicketsBookedByBookingId(bookingId);
        bookedSeats= bookedSeats.trim();
        System.out.println(bookedSeats);
        String[] bookedSeatsString = bookedSeats.split("\\s+");
        List<Integer> intBookedSeats = new ArrayList<>();
        for (String numStr : bookedSeatsString) {
            intBookedSeats.add(Integer.parseInt(numStr));
        }
        List<Integer> upddatedBookedSeats = new ArrayList<>();
        for (int seat : intBookedSeats) {
            if (cancelSeats.contains(seat)) {
            } else {
                upddatedBookedSeats.add(seat);
            }
        }
        String updatedBookedSeatsString = upddatedBookedSeats.stream() .map(Object::toString).reduce((s1, s2) -> s1 + " " + s2).orElse("");
//        System.out.println(upddatedBookedSeats);
//        String updatedBookedSeatsString = "";
//        for (int seat : upddatedBookedSeats) {
//            updatedBookedSeatsString = updatedBookedSeatsString +" "+ seat;
//        }
        System.out.println(updatedBookedSeatsString);
        bookingRepository.updateSeatsByBookingId(bookingId, updatedBookedSeatsString);
        int showId = bookingRepository.findShowIdByBookingId(bookingId);
        String seatsShow = showService.getSeatsByShowId(showId);
        String updatedSeats = "";
        for (int i = 0; i < seatsShow.length(); i++) {
            if (cancelSeats.contains(i + 1)) {
                updatedSeats = updatedSeats + 'A';
            } else {
                updatedSeats = updatedSeats +seatsShow.charAt(i);
            }
        }
        System.out.println(updatedSeats);
        showRepository.updateSeatsByShowId(showId, updatedSeats);
        return "Partially Cancelled";
    }

    public List<Object[]> getCustomerBookingsBeforeCurrentDate(String customerId, LocalDateTime currentTime) {
        return bookingRepository.findCustomerBookingsBeforeCurrentDate(customerId, currentTime);
    }

    public List<Object[]> getCustomerBookingsAfterCurrentDate(String customerId, LocalDateTime currentTime) {
        return bookingRepository.findCustomerBookingsAfterCurrentDate(customerId, currentTime);
    }
}
