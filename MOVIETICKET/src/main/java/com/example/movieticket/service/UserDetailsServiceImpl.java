package com.example.movieticket.service;

import com.example.movieticket.model.Login;
import com.example.movieticket.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final LoginRepository loginRepository;

    @Autowired
    public UserDetailsServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user details from repository
        Login login = loginRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Build UserDetails object
        return org.springframework.security.core.userdetails.User.builder()
                .username(login.getUsername())
                .password(login.getPassword()) // Assuming password is stored in plaintext in the database
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("USER")))
                .build();
    }

    public boolean authenticate(String username, String rawPassword) {
        // Load user details from repository
        Login login = loginRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Verify password
        return rawPassword.equals(login.getPassword());
    }
}
