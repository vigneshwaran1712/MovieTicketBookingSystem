package com.example.movieticket.repository;
import com.example.movieticket.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AdminRepository extends JpaRepository<Admin, String>{
}
