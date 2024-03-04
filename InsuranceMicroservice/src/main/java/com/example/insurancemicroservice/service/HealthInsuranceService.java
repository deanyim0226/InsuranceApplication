package com.example.insurancemicroservice.service;


import com.example.insurancemicroservice.domain.HealthInsurance;
import com.example.insurancemicroservice.repository.HealthInsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthInsuranceService {

    @Autowired
    HealthInsuranceRepository healthInsuranceRepository;

    public List<HealthInsurance> getAllInsurances(){

        return healthInsuranceRepository.findAll();
    }

    public HealthInsurance getInsurance(){
        return healthInsuranceRepository.findById(Long.valueOf(1)).orElse(null);
    }

}
