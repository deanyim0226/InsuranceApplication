package com.example.insurancemicroservice.controller;

import com.example.insurancemicroservice.domain.HealthPlan;
import com.example.insurancemicroservice.service.HealthPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HealthPlanController {

    @Autowired
    HealthPlanService healthPlanService;

    @GetMapping("/getAllHealthPlan")
    public List<HealthPlan> getAllHealthPlan(){
        return healthPlanService.getAllHealthPlans();
    }

    @GetMapping("/getHealthPlanByType/{planType}")
    public HealthPlan getHealthPlan(@PathVariable String planType){

        return healthPlanService.getHealthPlan(planType);
    }

    /*
    recommendation engine is needed to generate health plans to users
    based on user info.

    for now just think about the action that happens next

    get customer information to fill out the application
    at this stage user must have an account with us.

    ask questions
    * do you have account? existing account
    * or new user

    if it is new just take user to register form
    but user lost data? data will be saved

     */
}

