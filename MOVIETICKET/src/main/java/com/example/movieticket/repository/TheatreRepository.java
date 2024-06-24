
package com.example.movieticket.repository;

import com.example.movieticket.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

    @Query("SELECT t.theatreId FROM Theatre t WHERE t.city = :city")
    List<Integer> findTheatreIdsByCity(@Param("city") String city);

}
