package com.example.insurancegateway.controller;

import com.example.insurancegateway.client.CustomerClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerClient customerClient;


    @PostMapping("saveCustomer")
    public JsonNode saveCustomer(@RequestBody JsonNode customer){

        return customerClient.saveCustomer(customer);
    }
}
