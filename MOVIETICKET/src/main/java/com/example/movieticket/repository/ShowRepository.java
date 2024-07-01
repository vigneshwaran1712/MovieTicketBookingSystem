package com.example.movieticket.repository;

import com.example.movieticket.dto.TheatreInfoDTO;
import com.example.movieticket.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {


    //@Query("SELECT DISTINCT screenId FROM Show WHERE movieId IN: movieIds")
    //List<Integer> findScreenIdsByMovieIds(@Param("movieIds") List<Integer> movieIds);


    @Query("SELECT sh " +
            "FROM Show sh " +
            "WHERE sh.movieId = :movieId " +
            "AND sh.ScreenId IN :screenIds " +
            "AND sh.startTime > :currentTime")
    List<Show> findShowsByMovieIdAndScreenIdsAfterCurrentTime(
            @Param("movieId") Integer movieId,
            @Param("screenIds") List<Integer> screenIds,
            @Param("currentTime") LocalDateTime currentTime);



//    @Query("SELECT s.showId, s.startTime, s.endTime, s.seats, m.ticketPrice " +
//            "FROM Show s INNER JOIN Movie m ON s.movieId = m.movieId " +
//            "WHERE s.movieId = :movieId AND s.screenId IN :screenIds AND s.startTime > :currentDateTime ")
//    List<Object[]> findShowDetailsByMovieIdAndScreenIds(@Param("movieId") Integer movieId, @Param("screenIds") List<Integer> screenIds, LocalDateTime currentDateTime);

    @Transactional
    @Modifying
    @Query("UPDATE Show s SET s.seats = :newSeats WHERE s.showId = :showId")
    void updateSeatsByShowId(int showId, String newSeats);

    @Query("SELECT seats FROM Show WHERE showId = :showId")
    String findSeatByShowId(@Param("showId") Integer showId);

    @Query("SELECT s FROM Show s WHERE s.showId = :showId")
    List<Show> findShowsByShowId(@Param("showId") int showId);
//
}

