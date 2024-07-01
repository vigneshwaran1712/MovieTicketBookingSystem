package com.example.movieticket.controller;
import com.example.movieticket.dto.TheatreInfoDTO;
import com.example.movieticket.model.Theatre;
import com.example.movieticket.service.LoginService;
import com.example.movieticket.service.TheatreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/authenticate")
public class MovieClickController {

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private LoginService loginService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/movieClick")
    public ResponseEntity<?> movieClick(@RequestParam int movieId, @RequestParam String city) throws NoSuchFieldException, IllegalAccessException, JsonProcessingException {
        System.out.println("moviewwwwwww");
        System.out.println(movieId);
        System.out.println(city.isBlank()||city.isEmpty()||city==null);
        if (city.isBlank()){
            System.out.println("hLLO");
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            String userCity = loginService.getCityByEmail(username);
            System.out.println(userCity);
            List<TheatreInfoDTO> temp =  theatreService.getTheatresByMovieIdAndCity(movieId, userCity);
            return ResponseEntity.ok(temp);
        }
        System.out.println("hLO233");
        System.out.println(city);
        List<TheatreInfoDTO> temp =  theatreService.getTheatresByMovieIdAndCity(movieId,city);
        return ResponseEntity.ok(temp);
    }
}
