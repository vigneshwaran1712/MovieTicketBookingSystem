package com.example.movieticket.service;

import com.example.movieticket.model.Customer;
import com.example.movieticket.repository.CustomerRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getUserCityByUsername(String email) {
        return customerRepository.findCityByEmail(email);
    }
}
