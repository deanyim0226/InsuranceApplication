package com.example.insurancegateway.controller;

import com.example.insurancegateway.client.PaymentClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    PaymentClient paymentClient;

    @PostMapping("/create-payment-intent")
    public JsonNode createPaymentIntent(@RequestBody JsonNode request){

        System.out.println("create payment intent method is called");
        return paymentClient.createPaymentIntent(request);
    }

    @PostMapping("/confirm-payment")
    public JsonNode confirmPayment(@RequestBody JsonNode request){
        System.out.println("confirm payment method is called");
        return paymentClient.confirmPayment(request);
    }

    @PostMapping("/create-stripe-customer")
    public JsonNode completePayment(@RequestBody JsonNode request){
        System.out.println("complete payment method is called");
        return paymentClient.createStripeCustomer(request);
    }
}
