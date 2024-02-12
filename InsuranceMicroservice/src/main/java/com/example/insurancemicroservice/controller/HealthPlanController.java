package com.example.insurancemicroservice.controller;

import com.example.insurancemicroservice.domain.HealthPlan;
import com.example.insurancemicroservice.service.HealthPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthPlanController {

    @Autowired
    HealthPlanService healthPlanService;

    @GetMapping("/getAllHealthPlan")
    public List<HealthPlan> getAllHealthPlan(){
        return healthPlanService.getAllHealthPlans();
    }

}

