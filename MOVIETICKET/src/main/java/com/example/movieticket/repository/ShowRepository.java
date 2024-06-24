package com.example.movieticket.repository;

import com.example.movieticket.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Integer> {

    @Query("SELECT s FROM Show s WHERE STR_TO_DATE(s.startTime, '%Y-%m-%d %H:%i:%s') > STR_TO_DATE(:startTime, '%Y-%m-%d %H:%i:%s')")
    List<Show> findShowsByStartTimeGreaterThan(@Param("startTime") String startTime);
}
