package com.example.movieticket.controller;

import com.example.movieticket.model.Customer;
import com.example.movieticket.model.Login;
import com.example.movieticket.dto.CustomerRegistrationDTO;
import com.example.movieticket.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class RegistrationController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public String registerCustomer(@RequestBody CustomerRegistrationDTO registrationRequest) {

        System.out.println(registrationRequest);
        String username = registrationRequest.getUsername();
        String password = registrationRequest.getPassword();
        String name = registrationRequest.getName();
        String phone = registrationRequest.getPhone();
        String city = registrationRequest.getCity();
        boolean admin = registrationRequest.isAdmin();

        // Create Login entity
        Login login = new Login(username, password, admin);
        Customer customer = new Customer(username, name, phone, city, login);

        // Call service to handle registration logic
        loginService.registerCustomer(customer, login);
        return "Registration successful!";
    }
}
