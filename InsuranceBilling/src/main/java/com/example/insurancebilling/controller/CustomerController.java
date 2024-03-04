package com.example.insurancebilling.controller;

import com.example.insurancebilling.domain.Customer;
import com.example.insurancebilling.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("saveCustomer")
    public Customer saveCustomer(@RequestBody Customer customer){
        System.out.println("save customer is called");
        return customerService.saveCustomer(customer);
    }
}
