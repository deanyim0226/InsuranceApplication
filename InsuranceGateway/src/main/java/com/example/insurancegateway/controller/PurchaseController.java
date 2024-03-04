package com.example.insurancegateway.controller;

import com.example.insurancegateway.client.PurchaseClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseClient purchaseClient;

    @PostMapping("savePurchase")
    public JsonNode savePurchase(@RequestBody JsonNode purchase){


        return purchaseClient.savePurchase(purchase);
    }


    @GetMapping("getPurchaseById/{purchaseId}")
    public JsonNode getPurchaseById(@PathVariable String purchaseId){

        return purchaseClient.getPurchase(Long.valueOf(purchaseId));
    }

}
