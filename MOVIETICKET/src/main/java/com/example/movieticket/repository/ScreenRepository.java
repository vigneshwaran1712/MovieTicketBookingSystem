package com.example.movieticket.repository;

import com.example.movieticket.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer> {


    @Query("SELECT s.screenId FROM Screen s WHERE s.theatre.theatreId = :theatreId")
    List<Integer> findScreenIdsByTheatreId(@Param("theatreId") Integer theatreId);

    @Query("SELECT s.screenId FROM Screen s WHERE s.theatre.theatreId IN :theatreIds")
    List<Integer> findScreenIdsByTheatreIds(@Param("theatreIds") List<Integer> theatreIds);

    @Query("SELECT DISTINCT s.theatre.theatreId FROM Screen s WHERE s.screenId IN :screenIds")
    List<Integer> findTheatreIdsByScreenIds(@Param("screenIds") List<Integer> screenIds);

    @Query("SELECT screenId FROM Screen WHERE screenName = screenName")
    List<Integer> findScreenIdsByScreenName(@Param("screenName") String screenName);

    @Query("SELECT screenName FROM Screen WHERE theatre.theatreId = :theatreId")
    List<String> findScreenNamesByTheatreId(@Param("theatreId") Integer theatreId);

}
