package com.example.insurancemicroservice.controller;


import com.example.insurancemicroservice.domain.HealthInsurance;
import com.example.insurancemicroservice.service.HealthInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthInsuranceController {


    @Autowired
    HealthInsuranceService healthInsuranceService;

    @GetMapping("getAllInsurances")
    public List<HealthInsurance> getAllInsurances(){

        return healthInsuranceService.getAllInsurances();
    }

    @GetMapping("getInsurance")
    public HealthInsurance getInsurance(){

        return healthInsuranceService.getInsurance();
    }
}
