package com.example.insurancebilling.service;

import com.example.insurancebilling.domain.Customer;
import com.example.insurancebilling.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){


        return customerRepository.save(customer);
    }
}
