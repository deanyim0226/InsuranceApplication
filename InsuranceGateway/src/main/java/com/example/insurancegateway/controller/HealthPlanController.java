package com.example.insurancegateway.controller;


import com.example.insurancegateway.client.HealthPlanClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthPlanController {


    @Autowired
    HealthPlanClient healthPlanClient;

    @GetMapping("getAllHealthPlans")
    public JsonNode getAllHealthPlans(){
        System.out.println("being called");
        return healthPlanClient.getAllHealthPlans();
    }

    @GetMapping("getHealthPlanByType/{planType}")
    public JsonNode getHealthPlan(@PathVariable String planType){
        System.out.println("plantype is " + planType);
        return healthPlanClient.getHealthPlan(planType);
    }
}
