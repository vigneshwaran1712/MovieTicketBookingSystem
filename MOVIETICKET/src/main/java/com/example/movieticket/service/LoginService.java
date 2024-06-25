package com.example.movieticket.service;
import com.example.movieticket.model.Customer;
import com.example.movieticket.model.Login;
import com.example.movieticket.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {


    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TheatreRepository theatreRepository;
    private final ScreenRepository screenRepository;
    private final ShowRepository showRepository;
    private final CustomerRepository customerRepository;


    @Autowired
    public LoginService(CustomerRepository customerRepository,LoginRepository loginRepository, TheatreRepository theatreRepository, ScreenRepository screenRepository, ShowRepository showRepository, PasswordEncoder passwordEncoder , AuthenticationManager authenticationManager) {
        this.customerRepository = customerRepository;
        this.loginRepository = loginRepository;
        this.theatreRepository = theatreRepository;
        this.screenRepository = screenRepository;
        this.showRepository = showRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Transactional
    public void registerCustomer(Customer customer, Login login) {
        // Save Login entity
        String tempPassword = login.getPassword();
        login.setPassword(passwordEncoder.encode(tempPassword));
        loginRepository.save(login);

        // Save Customer entity
        customerRepository.save(customer);

    }

    public Optional<Login> authenticate(String username, String password){
        System.out.println(password);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,password
                )
        );
        return Optional.of(loginRepository.findByUsername(username).orElseThrow());
    }
    // Method to search for a username and password in the LOGIN table
    //public Login findByUsernameAndPassword(String username, String password) {
        //return loginRepository.findByUsernameAndPassword(username, password);
    //}

    public List<Integer> getTheatreIdsByCity(String city){
        return theatreRepository.findTheatreIdsByCity(city);
    }

    public List<Integer> getScreenIdsByTheatreIds(List<Integer> theatreIds){
        System.out.println(theatreIds);
        return screenRepository.findScreenIdsByTheatreIds(theatreIds);
    }

    public String getCityByEmail(String email) {
        return loginRepository.findCityByEmail(email);
    }

    public List<Integer> getMovieIdsByScreenIdsAndCurrentTime(List<Integer> screenIds) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return showRepository.findMovieIdsByScreenIdsAndStartTimeGreaterThan(screenIds, currentDateTime);
    }

}
