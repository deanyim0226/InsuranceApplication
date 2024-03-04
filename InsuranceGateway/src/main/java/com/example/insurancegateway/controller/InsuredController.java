package com.example.insurancegateway.controller;

import com.example.insurancegateway.client.InsuredClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsuredController {

    @Autowired
    InsuredClient insuredClient;

    @PostMapping("updateInsured")
    public JsonNode updateInsured(@RequestBody JsonNode insured){

        return insuredClient.updateInsured(insured);
    }


    @PostMapping("saveInsured")
    public JsonNode saveInsured(@RequestBody JsonNode insured){

        return insuredClient.saveInsured(insured);
    }
}
