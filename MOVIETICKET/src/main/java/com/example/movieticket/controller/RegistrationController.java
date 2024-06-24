package com.example.movieticket.controller;

import com.example.movieticket.model.Admin;
import com.example.movieticket.model.Customer;
import com.example.movieticket.model.Login;
import com.example.movieticket.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/auth")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public String registerCustomer(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("city") String city,
            @RequestParam("admin") boolean admin
    ){

        // Create Login entity
        System.out.println(username);
        Login login = new Login(username, password, admin);

        // Create Customer entity
        Customer customer = new Customer(username, name, phone, city, login);

        // Call service to handle registration logic
        registrationService.registerCustomer(customer, login);

        return "Registration successful!";
    }
}
