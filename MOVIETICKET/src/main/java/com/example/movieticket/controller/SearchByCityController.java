package com.example.movieticket.controller;

import com.example.movieticket.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.movieticket.service.MovieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchByCityController {

    @Autowired
    private MovieService movieService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/authenticate/searchCity")
    public ResponseEntity<?> searchCity(@RequestParam String city) {
        List<Movie> movies = movieService.getMoviesByCityAndStartTimeAfter(city);
        return ResponseEntity.ok(movies);
    }
}



//@RequestMapping("/api/authenticate")
//@RestController
//public class SearchByCity {
//
//    private final LoginService loginService;
//
//    //private final MovieService movieService;
//
//    @Autowired
//    public SearchByCity(LoginService loginService, MovieService movieService) {
//        this.loginService = loginService;
//        this.movieService = movieService;
//
//
//    }
//
//    @PostMapping("/movieClick")
//    public String searchCity(@RequestParam String movieName, @RequestParam String city) throws NoSuchFieldException, IllegalAccessException, JsonProcessingException {
//        System.out.println("moviewwwwwww");
//        System.out.println(movieName);
//        System.out.println(city);
//        int movieId = loginService.getMovieIdByMovieName(movieName);
//        List<Integer> screenIds = loginService.getScreenIdsByMovieId(movieId);
//        System.out.println(screenIds);
//        List<Integer> theatreIds = loginService.getTheatreIdsByScreenIds(screenIds);
//        System.out.println(theatreIds);
//        List<Theatre> theatreDetails = new ArrayList<>();
//        if (city.equals("a")){
//            System.out.println("hLLO");
//            String username = SecurityContextHolder.getContext().getAuthentication().getName();
//            String userCity = loginService.getCityByEmail(username);
//            System.out.println(userCity);
//            theatreDetails = loginService.getTheatresByIdsAndCity(theatreIds, userCity);
//        }
//        else {
//            System.out.println("hLO233");
//            System.out.println(city);
//            System.out.println(city.equals("a"));
//            theatreDetails = loginService.getTheatresByIdsAndCity(theatreIds, city);
//        }
//        System.out.println("hLO");
//        System.out.println(theatreDetails);
//        System.out.println("Theatre details");
//        TheatreScreenDetailsBuilder builder = new TheatreScreenDetailsBuilder();
//        List<TheatreScreenDetails> theatreScreenDetails = builder.buildTheatreScreenDetails(theatreDetails);
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(theatreScreenDetails);
//        System.out.println(json);
//        return json;
//    }
//}