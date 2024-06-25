package com.example.movieticket.repository;

import com.example.movieticket.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Integer> {


    @Query("SELECT DISTINCT s.movieId FROM Show s WHERE s.screenId IN :screenIds " +
            "AND s.startTime > :startTime")
    List<Integer> findMovieIdsByScreenIdsAndStartTimeGreaterThan(
            @Param("screenIds") List<Integer> screenIds,
            @Param("startTime") LocalDateTime startTime);
}
