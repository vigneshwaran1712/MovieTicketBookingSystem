package com.example.movieticket.service;

import com.example.movieticket.model.Login;
import com.example.movieticket.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;

@Service
public class LoginService {


    private final LoginRepository loginRepository;
    private final TheatreRepository theatreRepository;
    private final ScreenRepository screenRepository;
    private final ShowRepository showRepository;


    @Autowired
    public LoginService(LoginRepository loginRepository, TheatreRepository theatreRepository, ScreenRepository screenRepository, ShowRepository showRepository) {
        this.loginRepository = loginRepository;
        this.theatreRepository = theatreRepository;
        this.screenRepository = screenRepository;
        this.showRepository = showRepository;
    }

    // Method to search for a username and password in the LOGIN table
    public Login findByUsernameAndPassword(String username, String password) {
        return loginRepository.findByUsernameAndPassword(username, password);
    }

    public List<Integer> getTheatreIdsByCity(String city){
        return theatreRepository.findTheatreIdsByCity(city);
    }

    public List<Integer> getScreenIdsByTheatreIds(List<Integer> theatreIds){
        System.out.println(theatreIds);
        return screenRepository.findScreenIdsByTheatreIds(theatreIds);
    }

    public String getCityByEmail(String email) {
        return loginRepository.findCityByEmail(email);
    }

    public List<Integer> getMovieIdsByScreenIdsAndCurrentTime(List<Integer> screenIds) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return showRepository.findMovieIdsByScreenIdsAndStartTimeGreaterThan(screenIds, currentDateTime);
    }

}
