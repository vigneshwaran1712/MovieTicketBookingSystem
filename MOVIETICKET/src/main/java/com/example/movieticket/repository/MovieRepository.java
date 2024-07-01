package com.example.movieticket.repository;

import com.example.movieticket.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT DISTINCT m FROM Movie m " +
            "JOIN Show s ON m.movieId = s.movieId " +
            "JOIN Screen sc ON s.ScreenId = sc.screenId " +
            "JOIN Theatre t ON sc.theatre.theatreId = t.theatreId " +
            "WHERE t.city = :city AND s.startTime > :currentTime")
    List<Movie> findMoviesByCityAndStartTimeAfter(@Param("city") String city,
                                                  @Param("currentTime") LocalDateTime currentTime);
}