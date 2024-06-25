package com.example.movieticket.repository;

import com.example.movieticket.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

    Login findByUsernameAndPassword(String username, String password);

    @Query("SELECT c.city FROM Customer c WHERE c.email = :email")
    String findCityByEmail(@Param("email") String email);


    Optional<Login> findByUsername(String username);
}

