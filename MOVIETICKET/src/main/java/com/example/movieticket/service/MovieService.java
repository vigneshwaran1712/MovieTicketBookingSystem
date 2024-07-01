//package com.example.movieticket.service;
//
//import com.example.movieticket.model.Movie;
//import com.example.movieticket.repository.MovieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class MovieService {
//
//    @Autowired
//    private MovieRepository movieRepository;
//
////    public List<Movie> getMovieDetails(List<Integer> movieIds) {
////        return movieRepository.findMoviesByMovieIds(movieIds);
//        return movies.stream()
//                .map(movie -> List.of(
//                        movie.getMovieName(),
//                        movie.getActor(),
//                        movie.getActress(),
//                        movie.getDirector(),
//                        movie.getGenre(),
//                        movie.getImageUrl(),
//                        movie.getLength()
//                ))
////////                .collect(Collectors.toList());
//    }
//}

package com.example.movieticket.service;

import com.example.movieticket.model.Movie;
import com.example.movieticket.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieService {

        @Autowired
        private MovieRepository movieRepository;

        public List<Movie> getMoviesByCityAndStartTimeAfter(String city) {
                LocalDateTime currentTime = LocalDateTime.now();
                return movieRepository.findMoviesByCityAndStartTimeAfter(city, currentTime);
        }
}

