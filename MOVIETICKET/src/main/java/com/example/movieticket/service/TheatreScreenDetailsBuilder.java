package com.example.movieticket.service;

import com.example.movieticket.service.TheatreScreenDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.movieticket.model.Theatre;
import com.example.movieticket.model.Screen;

import java.util.ArrayList;
import java.util.List;

public class TheatreScreenDetailsBuilder {

    public List<TheatreScreenDetails> buildTheatreScreenDetails(List<Theatre> theatreDetails) {
        List<TheatreScreenDetails> result = new ArrayList<>();

        for (Theatre theatre : theatreDetails) {
            TheatreScreenDetails theatreDetailsObject = new TheatreScreenDetails(
                    theatre.getTheatreId(),
                    theatre.getName(),
                    theatre.getAddress(),
                    theatre.getCity(),
                    extractScreenNames(theatre.getScreens())
            );

            result.add(theatreDetailsObject);
        }

        return result;
    }

    private List<String> extractScreenNames(List<Screen> screens) {
        List<String> screenNames = new ArrayList<>();
        for (Screen screen : screens) {
            screenNames.add(screen.getScreenName());
        }
        return screenNames;
    }
}
