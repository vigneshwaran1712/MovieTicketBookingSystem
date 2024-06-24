package com.example.movieticket.service;

import com.example.movieticket.model.Customer;
import com.example.movieticket.model.Login;
import com.example.movieticket.repository.CustomerRepository;
import com.example.movieticket.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RegistrationService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Transactional
    public void registerCustomer(Customer customer, Login login) {
        // Save Login entity
        loginRepository.save(login);

        // Save Customer entity
        customerRepository.save(customer);

        // Handle file if necessary

    }
}
