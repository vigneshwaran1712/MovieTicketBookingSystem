package com.example.movieticket.controller;

import com.example.movieticket.dto.AdminDTO;
import com.example.movieticket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//For registration of admin and their theatres and screens
@RestController
@RequestMapping("/api/auth")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/registerAdmin")
    public ResponseEntity<String> registerAdmin(@RequestBody AdminDTO adminRequest) {
        System.out.println(adminRequest.getEmail());
        System.out.println(adminRequest.getPassword());
        System.out.println(adminRequest.getName());
        System.out.println(adminRequest.getTheatres());
        adminService.saveAdminWithTheatreDetails(adminRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Admin registered successfully.");
    }

}
