package com.example.insurancegateway.controller;

import com.example.insurancegateway.client.PolicyClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PolicyController {

    @Autowired
    PolicyClient policyClient;

    @PostMapping("savePolicy")
    public JsonNode savePolicy(@RequestBody JsonNode policy){
        return policyClient.savePolicy(policy);
    }

    @PostMapping("updatePolicy")
    public JsonNode updatePolicy(@RequestBody JsonNode policy){
        return policyClient.updatePolicy(policy);
    }

    @GetMapping("getPolicyById/{policyId}")
    public JsonNode getPolicyById(@PathVariable String policyId){

        return policyClient.getPolicyById(Long.valueOf(policyId));
    }
}
