package com.example.insurancebilling.controller;

import com.example.insurancebilling.domain.Insured;
import com.example.insurancebilling.domain.Policy;
import com.example.insurancebilling.domain.Purchasing;
import com.example.insurancebilling.service.EmailService;
import com.example.insurancebilling.service.InsuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class InsuredController {

    @Autowired
    InsuredService insuredService;

    @Autowired
    EmailService emailService;

    @PostMapping("saveInsured")
    public Insured saveInsured(@RequestBody Insured insured){

        return insuredService.saveInsured(insured);
    }

    @PostMapping("updateInsured")
    public Insured updateInsured(@RequestBody Insured insured){
        Insured updatedInsured = insuredService.updateInsured(insured);

        if(updatedInsured == null){
            return null;
            //error
        }

        return updatedInsured;
    }
}
