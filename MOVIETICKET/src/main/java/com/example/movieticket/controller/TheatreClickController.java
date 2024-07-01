package com.example.movieticket.controller;

import com.example.movieticket.repository.ScreenRepository;
import com.example.movieticket.repository.ShowRepository;
import com.example.movieticket.service.ScreenService;
import com.example.movieticket.service.ShowService;
import com.example.movieticket.service.TheatreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TheatreClickController {
    
    @Autowired
    private ShowService showService;

    @Autowired
    private ScreenService screenService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/authenticate/theatreClick")
    public ResponseEntity<?> theatreClick(@RequestBody Map<String, Object> requestData) throws JsonProcessingException {
        System.out.println("OKKok");
        int theatreId = (int) requestData.get("theatreId");
        int movieId = (int) requestData.get("movieId");
        System.out.println(theatreId);
        List<Integer> screenIds = screenService.getScreenIdsByTheatreId(theatreId);
        System.out.println(screenIds);
        System.out.println(showService.getShowsByMovieIdAndTheatreIdAfterCurrentTime(movieId,screenIds));
        return ResponseEntity.ok(showService.getShowsByMovieIdAndTheatreIdAfterCurrentTime(movieId,screenIds));
    }
}
