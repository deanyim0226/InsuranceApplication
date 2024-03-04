package com.example.insurancebilling.controller;


import com.example.insurancebilling.domain.Purchasing;
import com.example.insurancebilling.service.EmailService;

import com.example.insurancebilling.service.PurchaseService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;


@RestController
public class PurchaseController {

    @Autowired
    EmailService emailService;

    @Autowired
    PurchaseService purchaseService;


    @PostMapping("savePurchasing")
    public Purchasing savePurchasing(@RequestBody Purchasing purchasing){

        Purchasing purchaseInfo = purchaseService.savePurchasing(purchasing);

        if(purchaseInfo != null){

            CompletableFuture.runAsync(()->{

                try{
                    emailService.sendConfirmation(purchaseInfo);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
        
        return purchaseInfo;
    }


    @GetMapping("getPurchaseById/{purchaseId}")
    public Purchasing getPurchaseById(@PathVariable Long purchaseId){
        System.out.println("get is called");
        return purchaseService.getPurchaseById(purchaseId);
    }



}
