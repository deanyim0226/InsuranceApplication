package com.example.insurancegateway.controller;

import com.example.insurancegateway.client.InsuranceClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsuranceController {

    @Autowired
    InsuranceClient insuranceClient;

    @GetMapping("getAllInsurances")
    public JsonNode getAllInsurances(){

        return insuranceClient.getAllInsurances();
    }

    @GetMapping("getInsurance")
    public JsonNode getInsurance(){
        return insuranceClient.getInsurance();
    }
}
