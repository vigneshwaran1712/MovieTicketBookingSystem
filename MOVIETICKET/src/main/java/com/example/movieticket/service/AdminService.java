package com.example.movieticket.service;

import com.example.movieticket.model.Login;
import com.example.movieticket.repository.AdminRepository;
import com.example.movieticket.repository.LoginRepository;
import com.example.movieticket.repository.ScreenRepository;
import com.example.movieticket.repository.TheatreRepository;
import com.example.movieticket.request.AdminRequest;
import com.example.movieticket.request.ScreenRequest;
import com.example.movieticket.request.TheatreRequest;
import com.example.movieticket.model.Admin;
import com.example.movieticket.model.Screen;
import com.example.movieticket.model.Theatre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private LoginRepository loginRepository;

    @Transactional
    public void saveAdminWithTheatreDetails(AdminRequest adminRequest) {
        // Extract admin details
        String name = adminRequest.getName();
        String email = adminRequest.getEmail();
        String password = adminRequest.getPassword();

        // Create Admin entity
        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setName(name);

        Login login = new Login();
        login.setPassword(password);
        login.setUsername(email);

        loginRepository.save(login);
        // Save admin
        adminRepository.save(admin);

        // Process theatres
        List<TheatreRequest> theatreRequests = adminRequest.getTheatres();
        for (TheatreRequest theatreRequest : theatreRequests) {
            // Create Theatre entity
            Theatre theatre = new Theatre();
            theatre.setName(theatreRequest.getName());
            theatre.setCity(theatreRequest.getCity());
            theatre.setAdmin(admin);
            theatre.setAddress(theatreRequest.getAddress());// Set admin for theatre

            // Save theatre
            theatreRepository.save(theatre);

            // Process screens
            List<ScreenRequest> screenRequests = theatreRequest.getScreens();
            for (ScreenRequest screenRequest : screenRequests) {
                // Create Screen entity
                Screen screen = new Screen();
                screen.setScreenName(screenRequest.getName());
                screen.setNoOfSeats(screenRequest.getNo_of_seats());
                screen.setTheatre(theatre); // Set theatre for screen

                // Save screen
                screenRepository.save(screen);
            }
        }
    }
}
