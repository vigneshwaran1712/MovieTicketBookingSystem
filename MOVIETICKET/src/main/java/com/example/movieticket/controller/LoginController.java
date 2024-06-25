package com.example.movieticket.controller;

import com.example.movieticket.model.Login;
import com.example.movieticket.service.LoginService;
import com.example.movieticket.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private MovieService movieService;

    private ArrayList<Dictionary<String, String>> movieDetailsJson;

    public LoginController() {
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
        Login isAuthenticated = loginService.findByUsernameAndPassword(login.getUsername(), login.getPassword());
        if (isAuthenticated != null) {
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
                 movieDetailsJsonDummy.add(temp);
            }
            this.setMovieDetailsJson(movieDetailsJsonDummy);

            return "Login Successful";
        } else {
            return "Login failed. Invalid username or password.";
        }
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
