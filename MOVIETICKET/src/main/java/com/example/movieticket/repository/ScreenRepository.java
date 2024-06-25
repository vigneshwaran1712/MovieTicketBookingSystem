package com.example.movieticket.repository;

import com.example.movieticket.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer> {

    @Query("SELECT s.screenId FROM Screen s WHERE s.theatre.theatreId IN :theatreIds")
    List<Integer> findScreenIdsByTheatreIds(@Param("theatreIds") List<Integer> theatreIds);
}
