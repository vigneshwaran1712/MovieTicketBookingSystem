package com.example.movieticket.controller;


import com.example.movieticket.request.AdminRequest;
import com.example.movieticket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerAdmin(@RequestBody AdminRequest adminRequest) {
        adminService.saveAdminWithTheatreDetails(adminRequest);
        System.out.println(adminRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Admin registered successfully.");
    }

}
