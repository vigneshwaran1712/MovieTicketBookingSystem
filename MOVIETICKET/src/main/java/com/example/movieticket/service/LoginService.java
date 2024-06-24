package com.example.movieticket.service;

import com.example.movieticket.model.Login;
import com.example.movieticket.repository.LoginRepository;
import com.example.movieticket.repository.MovieCityRepository;
import com.example.movieticket.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {


    private final LoginRepository loginRepository;
    private final TheatreRepository theatreRepository;


    @Autowired
    public LoginService(LoginRepository loginRepository, TheatreRepository theatreRepository) {
        this.loginRepository = loginRepository;
        this.theatreRepository = theatreRepository;

    }

    // Method to search for a username and password in the LOGIN table
    public Login findByUsernameAndPassword(String username, String password) {
        return loginRepository.findByUsernameAndPassword(username, password);
    }

    public List<Integer> getTheatreIdsByCity(String city){
        return theatreRepository.findTheatreIdsByCity(city);
    }

    public String getCityByEmail(String email) {
        return loginRepository.findCityByEmail(email);
    }

}
