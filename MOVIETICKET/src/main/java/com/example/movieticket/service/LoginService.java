package com.example.movieticket.service;
import com.example.movieticket.model.*;
import com.example.movieticket.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LoginService {

    private final BookingRepository bookingRepository;
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TheatreRepository theatreRepository;
    private final ScreenRepository screenRepository;
    private final ShowRepository showRepository;
    private final CustomerRepository customerRepository;
    private final MovieRepository movieRepository;


    @Autowired
    public LoginService(CustomerRepository customerRepository, LoginRepository loginRepository, TheatreRepository theatreRepository, ScreenRepository screenRepository, ShowRepository showRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, MovieRepository movieRepository, BookingRepository bookingRepository) {
        this.customerRepository = customerRepository;
        this.loginRepository = loginRepository;
        this.theatreRepository = theatreRepository;
        this.screenRepository = screenRepository;
        this.showRepository = showRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.movieRepository = movieRepository;
        this.bookingRepository = bookingRepository;
    }

    @Transactional
    public void registerCustomer(Customer customer, Login login) {

        String tempPassword = login.getPassword();
        login.setPassword(passwordEncoder.encode(tempPassword));
        loginRepository.save(login);


        customerRepository.save(customer);

    }

    public Optional<Login> authenticate(String username, String password) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username, password
                )
        );
        return Optional.of(loginRepository.findByUsername(username).orElseThrow());
    }

//    public List<Theatre> getMovieDetailsByCity(String email){
//        return movieRepository.findMoviesByCustomerEmail(email);
//    }
    // Method to search for a username and password in the LOGIN table
    //public Login findByUsernameAndPassword(String username, String password) {
    //return loginRepository.findByUsernameAndPassword(username, password);
    //}

    public List<Integer> getTheatreIdsByCity(String city) {

        return theatreRepository.findTheatreIdsByCity(city);
    }

//    public List<Integer> getScreenIdsByTheatreIds(List<Integer> theatreIds) {
//        return screenRepository.findScreenIdsByTheatreIds(theatreIds);
//    }

    public String getCityByEmail(String email) {
        return loginRepository.findCityByEmail(email);
    }
}

//    public List<Integer> getMovieIdsByScreenIdsAndCurrentTime(List<Integer> screenIds) {
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        return showRepository.findMovieIdsByScreenIdsAndStartTimeGreaterThan(screenIds, currentDateTime);
//    }

//    public int getMovieIdByMovieName(String movieName){
//        return movieRepository.findMovieIdByMovieName(movieName);
//    }

//    public List<Integer> getScreenIdsByMovieId(int movieId) {
//        return showRepository.findScreenIdsByMovieId(movieId);
//    }

//    public List<Integer> getScreenIdsByMovieIds(List<Integer> movieIds) {
//        return showRepository.findScreenIdsByMovieIds(movieIds);
//    }

//    public List<Integer> getTheatreIdsByScreenIds(List<Integer> screenIds) {
//        return screenRepository.findTheatreIdsByScreenIds(screenIds);
//    }
//
//    public List<Theatre> getTheatresByIdsAndCity(List<Integer> theatreIds, String city) {
//        return theatreRepository.findAllByIdAndCity(theatreIds,city);
//    }
//
//    public List<Theatre> getTheatresByIds(List<Integer> theatreIds) {
//        return theatreRepository.findAllById(theatreIds);
//    }
//
//    public List<Integer> getScreenIdsByScreenName(String screenName) {
//        return screenRepository.findScreenIdsByScreenName(screenName);
//    }

//    public String getShowDetailsByMovieIdAndScreenIds(Integer movieId, List<Integer> screenIds) throws JsonProcessingException {
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        System.out.println(movieId);
//        System.out.println(screenIds);
//        List<Object[]> showDetails = showRepository.findShowDetailsByMovieIdAndScreenIds(movieId, screenIds, currentDateTime);
//        System.out.println(showDetails);
//        List<Dictionary<String, Object>> mappedResults = new ArrayList<>();
//        for (Object[] detail : showDetails) {
//            Dictionary<String, Object> showInfo = new Hashtable<>();
//            //System.out.println("what is details");
//            //System.out.println(detail[0]);
//            //System.out.println(detail[1]);
//            //System.out.println(detail[2]);
//            //System.out.println(detail[3]);
//            //System.out.println(detail[4]);
//            LocalDateTime dateTime = (LocalDateTime) detail[1];
//            LocalDate date = dateTime.toLocalDate();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            String formattedDate = date.format(formatter);
//            //System.out.println(date);
//            showInfo.put("showId",detail[0]);
//            showInfo.put("date", formattedDate);
//            Dictionary<String, Object> shows = new Hashtable<>();
//            shows.put("startTime", detail[1]);
//            shows.put("endTime", detail[2]);
//            shows.put("seats", detail[3]);
//            showInfo.put("shows", shows);
//            showInfo.put("price", detail[4]);
//            mappedResults.add(showInfo);
//        }
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(mappedResults);
//    }
//
//    public List<String> getTheatreNameByTheatreIds(List<Integer> tempTheatreIdsList) {
//        return theatreRepository.findTheatreNamesByTheatreIds(tempTheatreIdsList);
//    }
//

//

//
//        Booking booking = new Booking(cost, customerId, show);
//        booking.setTicketsBooked(seats);
//
//        bookingRepository.save(booking);
//    }
//
//    public List<Map<String, Object>> getTheatreAndScreenNamesByAdmin(String adminId) {
//        List<String> theatreNames = theatreRepository.findTheatreNamesByAdminId(adminId);
//        List<Map<String, Object>> result = new ArrayList<>();
//
//        for (String theatreName : theatreNames) {
//            Map<String, Object> theatreMap = new HashMap<>();
//            theatreMap.put("theatre", theatreName);
//
//            Integer theatreId = theatreRepository.findTheatreIdByName(theatreName);
//            List<String> screenNames = screenRepository.findScreenNamesByTheatreId(theatreId);
//
//            theatreMap.put("screens", screenNames);
//            result.add(theatreMap);
//        }
//
//        return result;
//    }
//}
