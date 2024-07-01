package com.example.movieticket.repository;
import com.example.movieticket.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query("SELECT city FROM Customer WHERE email = :email")
    String findCityByEmail(@Param("email") String email);
}
