package com.example.insurancemicroservice.service;

import com.example.insurancemicroservice.domain.HealthPlan;
import com.example.insurancemicroservice.repository.HealthPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthPlanService {

    @Autowired
    HealthPlanRepository healthPlanRepository;

    public List<HealthPlan> getAllHealthPlans(){
        return healthPlanRepository.findAll();
    }
}
