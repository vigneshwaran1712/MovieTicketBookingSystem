package com.example.movieticket.controller;

import com.example.movieticket.model.Show;
import com.example.movieticket.service.ShowService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ShowClickController {

    @Autowired
    private ShowService showService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/authenticate/showClick")
    public ResponseEntity<?> theatreClick(@RequestParam int showId) throws JsonProcessingException {
        List<Show> temp = showService.getShowsByShowId(showId);
        return ResponseEntity.ok(temp);
    }
}
