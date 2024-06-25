package com.example.movieticket.controller;

import com.example.movieticket.model.Login;
import com.example.movieticket.model.LoginResponse;
import com.example.movieticket.service.LoginService;
import com.example.movieticket.service.MovieService;
import com.example.movieticket.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final JwtService jwtService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private MovieService movieService;

    private ArrayList<Dictionary<String, String>> movieDetailsJson;

    public LoginController(JwtService jwtService) {
        this.jwtService = jwtService;
        ArrayList<Dictionary<String, String>> movieDetailsJson = new ArrayList<>();
    }

    public ArrayList<Dictionary<String, String>> getMovieDetailsJson(){
        return this.movieDetailsJson;
    }

    public void setMovieDetailsJson(ArrayList<Dictionary<String, String>> movieDetailsJson){
        this.movieDetailsJson = movieDetailsJson;
    }

    @PostMapping("/login")
    public String login(@RequestBody Login login) {
        System.out.println(login.getUsername());
        Optional<Login> isAuthenticated = loginService.authenticate(login.getUsername(), login.getPassword());
        System.out.println(isAuthenticated.isPresent());
        String jwtToken = jwtService.generateToken(isAuthenticated.get());
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        if (isAuthenticated.isPresent() && !login.isAdmin()) {
            String city = loginService.getCityByEmail(login.getUsername());
            System.out.println(city);
            List<Integer> theatreIdsByCity= loginService.getTheatreIdsByCity(city);
            List<Integer> screenIdsByTheatreId = loginService.getScreenIdsByTheatreIds(theatreIdsByCity);
            List<Integer> movieIds = loginService.getMovieIdsByScreenIdsAndCurrentTime(screenIdsByTheatreId);
            List<List<String>> movieDetails = movieService.getMovieDetails(movieIds);
            ArrayList<Dictionary<String, String>> movieDetailsJsonDummy = new ArrayList<>();
            for (int i = 0; i < movieDetails.size(); i++) {
                 Dictionary<String,String> temp = new Hashtable<>();
                 temp.put("name", movieDetails.get(i).get(0));
                 temp.put("actor", movieDetails.get(i).get(1));
                 temp.put("actress", movieDetails.get(i).get(2));
                 temp.put("director", movieDetails.get(i).get(3));
                 temp.put("genre", movieDetails.get(i).get(4));
                 temp.put("imgUrl", movieDetails.get(i).get(5));
                 temp.put("duration", movieDetails.get(i).get(6));
                 movieDetailsJsonDummy.add(temp);
            }
            this.setMovieDetailsJson(movieDetailsJsonDummy);
            //System.out.println(loginResponse);
            //System.out.println(String.valueOf(ResponseEntity.ok(loginResponse)));
            //System.out.println(this.movieDetailsJson);
            if (!String.valueOf(ResponseEntity.ok(loginResponse)).isEmpty()) {
                return loginResponse.getToken();
            }
        }
        return "";
    }
    @PostMapping("/userCityMovies")
    public ArrayList<Dictionary<String, String>> userCityMovies() {
        //System.out.println(movieDetailsJson);
        return this.getMovieDetailsJson();
    }

    @GetMapping("/searchCity")
    public ArrayList<Dictionary<String, String>> seachCity(@RequestParam String city){
        List<Integer> theatreIdsByCity= loginService.getTheatreIdsByCity(city);
        List<Integer> screenIdsByTheatreId = loginService.getScreenIdsByTheatreIds(theatreIdsByCity);
        List<Integer> movieIds = loginService.getMovieIdsByScreenIdsAndCurrentTime(screenIdsByTheatreId);
        List<List<String>> movieDetails = movieService.getMovieDetails(movieIds);
        movieDetailsJson = new ArrayList<>();
        for (int i = 0; i < movieDetails.size(); i++) {
            Dictionary<String,String> temp = new Hashtable<>();
            temp.put("name", movieDetails.get(i).get(0));
            temp.put("actor", movieDetails.get(i).get(1));
            temp.put("actress", movieDetails.get(i).get(2));
            temp.put("director", movieDetails.get(i).get(3));
            temp.put("genre", movieDetails.get(i).get(4));
            temp.put("imgUrl", movieDetails.get(i).get(5));
            movieDetailsJson.add(temp);
        }
        System.out.println(movieDetailsJson);
        return movieDetailsJson;
    }
}
