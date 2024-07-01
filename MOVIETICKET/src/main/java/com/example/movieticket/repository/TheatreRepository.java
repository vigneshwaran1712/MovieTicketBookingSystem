
package com.example.movieticket.repository;

import com.example.movieticket.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.movieticket.dto.TheatreInfoDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {


    @Query("SELECT DISTINCT new com.example.movieticket.dto.TheatreInfoDTO(t.theatreId ,t.name, t.city, t.address) " +
            "FROM Theatre t JOIN t.screens s JOIN Show sh ON s.screenId = sh.ScreenId " +
            "WHERE sh.movieId = :movieId AND t.city = :city AND sh.startTime > :currentTime")
    List<TheatreInfoDTO> findTheatreInfoByMovieIdAndCityAfterCurrentTime(@Param("movieId") Integer movieId, @Param("city") String city, @Param("currentTime") LocalDateTime currentTime);


    //@Query("SELECT DISTINCT t FROM Theatre t JOIN t.screens s JOIN Show sh ON s.screenId = sh.screenId WHERE sh.movieId = :movieId AND t.city = :city")
    //List<Theatre> findTheatresByMovieIdAndCity(@Param("movieId") Integer movieId, @Param("city") String city);


    @Query("SELECT t.theatreId FROM Theatre t WHERE t.city = :city")
    List<Integer> findTheatreIdsByCity(@Param("city") String city);


    @Query("SELECT theatre.name FROM Theatre theatre WHERE theatre.theatreId IN :theatreIds")
    List<String> findTheatreNamesByTheatreIds(@Param("theatreIds") List<Integer> theatreIds);


    @Query("SELECT name FROM Theatre WHERE admin.email = :adminId")
    List<String> findTheatreNamesByAdminId(@Param("adminId") String adminId);

    @Query("SELECT theatreId FROM Theatre WHERE name = :theatreName")
    Integer findTheatreIdByName(@Param("theatreName") String theatreName);


    @Query("SELECT t FROM Theatre t WHERE t.theatreId IN :theatreIds AND t.city = :city")
    List<Theatre> findAllByIdAndCity(@Param("theatreIds") List<Integer> theatreIds, @Param("city") String city);

}
