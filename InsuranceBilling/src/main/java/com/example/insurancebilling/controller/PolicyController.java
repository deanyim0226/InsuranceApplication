package com.example.insurancebilling.controller;

import com.example.insurancebilling.domain.Policy;
import com.example.insurancebilling.service.EmailService;
import com.example.insurancebilling.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
public class PolicyController {

    @Autowired
    PolicyService policyService;

    @Autowired
    EmailService emailService;

    @PostMapping("savePolicy")
    public Policy savePolicy(@RequestBody Policy policy){

        Policy savedPolicy = policyService.savePolicy(policy);

        if(savedPolicy != null){

            CompletableFuture.runAsync(()->{
                try{
                    emailService.sendPolicyInformation(savedPolicy);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }

        return savedPolicy;
    }

    @PostMapping("updatePolicy")
    public Policy updatePolicy(@RequestBody Policy policy){

        Policy updatedPolicy = policyService.updatePolicy(policy);

        if(updatedPolicy != null){
            CompletableFuture.runAsync(()->{
                try{
                    emailService.sendConfirmPolicy(updatedPolicy);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }

        return updatedPolicy;
    }

    @GetMapping("getPolicyById/{policyId}")
    public Policy getPolicy(@PathVariable Long policyId){

        Policy retrievedPolicy = policyService.getPolicyById(policyId);

        return retrievedPolicy;
    }
}
