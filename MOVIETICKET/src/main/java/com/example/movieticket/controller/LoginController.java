package com.example.movieticket.controller;

import com.example.movieticket.model.Login;
import com.example.movieticket.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody Login login) {
        Login isAuthenticated = loginService.findByUsernameAndPassword(login.getUsername(), login.getPassword());
        if (isAuthenticated != null) {
            String city = loginService.getCityByEmail(login.getUsername());
            List<Integer> theatreIdsByCity= loginService.getTheatreIdsByCity(city);
            System.out.println(theatreIdsByCity);
            return "Login Successful";
        } else {
            return "Login failed. Invalid username or password.";
        }


    }
}
