package com.example.movieticket.service;

import com.example.movieticket.dto.TheatreInfoDTO;
import com.example.movieticket.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    public List<TheatreInfoDTO> getTheatresByMovieIdAndCity(int movieId , String city){
        return theatreRepository.findTheatreInfoByMovieIdAndCityAfterCurrentTime(movieId, city, LocalDateTime.now());
    }
}
