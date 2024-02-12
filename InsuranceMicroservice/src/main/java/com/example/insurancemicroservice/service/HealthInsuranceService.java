package com.example.insurancemicroservice.service;


import com.example.insurancemicroservice.repository.HealthInsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthInsuranceService {

    @Autowired
    HealthInsuranceRepository healthInsuranceRepository;

}
