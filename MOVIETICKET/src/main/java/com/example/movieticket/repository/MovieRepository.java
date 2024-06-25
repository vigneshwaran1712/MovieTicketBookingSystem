package com.example.movieticket.repository;

import com.example.movieticket.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "SELECT * FROM Movie WHERE movie_id IN (:movieIds)", nativeQuery = true)
    List<Movie> findMoviesByMovieIds(@Param("movieIds") List<Integer> movieIds);

}