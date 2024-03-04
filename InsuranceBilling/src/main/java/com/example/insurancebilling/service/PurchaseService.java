package com.example.insurancebilling.service;

import com.example.insurancebilling.domain.Purchasing;
import com.example.insurancebilling.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;

    public Purchasing savePurchasing(Purchasing purchasing){

        return purchaseRepository.save(purchasing);
    }


    public Purchasing getPurchaseById(Long purchaseId){
        return purchaseRepository.findById(purchaseId).orElse(null);
    }
}
