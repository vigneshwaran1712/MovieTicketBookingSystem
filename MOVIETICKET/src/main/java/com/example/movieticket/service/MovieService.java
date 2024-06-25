package com.example.movieticket.service;

import com.example.movieticket.model.Movie;
import com.example.movieticket.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<List<String>> getMovieDetails(List<Integer> movieIds) {
        List<Movie> movies = movieRepository.findMoviesByMovieIds(movieIds);

        return movies.stream()
                .map(movie -> List.of(
                        movie.getMovieName(),
                        movie.getActor(),
                        movie.getActress(),
                        movie.getDirector(),
                        movie.getGenre(),
                        movie.getImageUrl()
                ))
                .collect(Collectors.toList());
    }
}
