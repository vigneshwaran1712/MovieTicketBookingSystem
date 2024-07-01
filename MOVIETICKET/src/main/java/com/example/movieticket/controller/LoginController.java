package com.example.movieticket.controller;
import com.example.movieticket.model.*;
import com.example.movieticket.repository.BookingRepository;
import com.example.movieticket.repository.CustomerRepository;
import com.example.movieticket.repository.ShowRepository;
import com.example.movieticket.service.LoginService;
import com.example.movieticket.service.MovieService;
import com.example.movieticket.service.JwtService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import com.example.movieticket.service.*;
import com.example.movieticket.service.CustomerService;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private JwtService jwtService;

    private ArrayList<Dictionary<String, Object>> movieDetailsJson;

    @Autowired
    private ShowService showService;

    public LoginController() {
    }

    public ArrayList<Dictionary<String, Object>> getMovieDetailsJson() {
        return this.movieDetailsJson;
    }

    public void setMovieDetailsJson(ArrayList<Dictionary<String, Object>> movieDetailsJson) {
        this.movieDetailsJson = movieDetailsJson;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        login.setUsername(login.getUsername());
        Optional<Login> isAuthenticated = loginService.authenticate(login.getUsername(), login.getPassword());
        String jwtToken = jwtService.generateToken(isAuthenticated.get());
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        System.out.println(login.isAdmin());
        System.out.println(login.getUsername());
        login.setToken(jwtToken);
        return ResponseEntity.ok(login);
    }

    @PostMapping("/authenticate/userCityMovies")
    public ResponseEntity<?> userCityMovies(HttpServletRequest request) {
        String username = null;
        String jwt = null;
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtService.extractUsername(jwt);
        }

        if (username != null) {
            String city = customerService.getUserCityByUsername(username);
            System.out.println(city);
            List<Movie> movies = movieService.getMoviesByCityAndStartTimeAfter(city);
            return ResponseEntity.ok(movies);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/authenticate/booking")
    public ResponseEntity<String> booking(@RequestBody Map<String, Object> requestData) throws JsonProcessingException {
        System.out.println("inn");
        System.out.println(requestData);
        int showId = (int) requestData.get("showId");
        int price = (int) requestData.get("price");
        System.out.println(showId);
        List<Integer> seats = (List<Integer>) requestData.get("seats");

        return ResponseEntity.ok(showService.bookSeats(showId, price, seats));
//
//    }
    }

    //
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/authenticate/cancel")
    public ResponseEntity<String> cancel(@RequestBody Map<String, Object> requestData) throws JsonProcessingException {
        System.out.print("  ");
        System.out.println("inn");
        Integer bookingId = Integer.valueOf(requestData.get("bookingId").toString());
        String seatsBooked = bookingRepository.findTicketsBookedByBookingId(bookingId);
        seatsBooked = seatsBooked.trim();
        int showId = bookingRepository.findShowIdByBookingId(bookingId);
        String[] numbersArray = seatsBooked.split("\\s+");
        List<Integer> seats = new ArrayList<>();
        for (String numStr : numbersArray) {
            seats.add(Integer.parseInt(numStr));
        }
        String updatedSeats = "";
        String seatsShow = showService.getSeatsByShowId(showId);
        for (int i = 0; i < seatsShow.length(); i++) {
            if (seats.contains(i + 1)) {
                updatedSeats = updatedSeats + 'A';
            } else {
                updatedSeats = updatedSeats + seatsShow.charAt(i);
            }
        }
        showRepository.updateSeatsByShowId(showId, updatedSeats);
        bookingRepository.deleteById(bookingId);
        return ResponseEntity.ok("Cancelled");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/authenticate/partialCancel")
    public ResponseEntity<String> partialCancel(@RequestBody Map<String, Object> requestData) throws JsonProcessingException {
        int bookingId = (int) requestData.get("bookingId");
        List<Integer> cancelSeats = (List<Integer>) requestData.get("cancelSeats");
        System.out.println(cancelSeats);
        System.out.println("okk");
        System.out.println(bookingId);
        return ResponseEntity.ok(bookingService.partialCancel(bookingId,cancelSeats));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("authenticate/pastBookings")
    public ResponseEntity<?> pastBookings(@RequestParam String customerId) throws JsonProcessingException {
        LocalDateTime currenTime = LocalDateTime.now();
        return ResponseEntity.ok(bookingService.getCustomerBookingsBeforeCurrentDate(customerId, currenTime));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("authenticate//currentBookings")
    public ResponseEntity<?> currentBookings(@RequestParam String customerId) throws JsonProcessingException {
        LocalDateTime currenTime = LocalDateTime.now();
        return ResponseEntity.ok(bookingService.getCustomerBookingsAfterCurrentDate(customerId, currenTime));
    }
}


//
//    @CrossOrigin(origins = "http://localhost:3000")
//    @RequestMapping("/authenticate/getAdminTheatres")
//    public String getAdminTheatres(@RequestParam String adminId) {
//        List<Map<String, Object>> theatreAndScreenNames = loginService.getTheatreAndScreenNamesByAdmin(adminId);
//
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            return mapper.writeValueAsString(theatreAndScreenNames);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error processing request";
//        }
//    }
//
//}
