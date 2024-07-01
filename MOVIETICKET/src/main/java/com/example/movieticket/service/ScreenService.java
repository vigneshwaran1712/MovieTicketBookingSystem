package com.example.movieticket.service;

import com.example.movieticket.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Collection;

@Service
public class ScreenService {

    @Autowired
    private ScreenRepository screenRepository;

    public List<Integer> getScreenIdsByTheatreId(int theatreId){
        return screenRepository.findScreenIdsByTheatreId(theatreId);
    }
}
