package com.example.insurancebilling.controller;

import com.example.insurancebilling.model.reponse.ConfirmPaymentResponse;
import com.example.insurancebilling.model.reponse.CreateCustomerResponse;
import com.example.insurancebilling.model.reponse.CreatePaymentResponse;
import com.example.insurancebilling.model.request.ConfirmPaymentRequest;
import com.example.insurancebilling.model.request.CreateCustomerRequest;
import com.example.insurancebilling.model.request.CreatePaymentRequest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${stripe.apikey}")
    String stripeKey;

    @PostConstruct
    public void init(){
        Stripe.apiKey = stripeKey;
    }

    @PostMapping("/create-checkout-session")
    public void createCheckoutSession() throws StripeException {
        Stripe.apiKey = stripeKey;

    }

    @PostMapping("/createCustomer")
    public CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) throws StripeException {
        System.out.println("create customer is called");
        System.out.println(request.getEmail() + " " + request.getFirstName() + " " + request.getLastName());
        Stripe.apiKey = stripeKey;

        CustomerCreateParams params =
                CustomerCreateParams.builder()
                        .setName(request.getFirstName() + " " + request.getLastName())
                        .setEmail(request.getEmail())
                        .build();

        com.stripe.model.Customer customer = com.stripe.model.Customer.create(params);

        return new CreateCustomerResponse(customer.getId());
    }


    @PostMapping("/confirm-payment")
    public ConfirmPaymentResponse confirmPayment(@RequestBody ConfirmPaymentRequest request) throws  StripeException{
        System.out.println("confirm payment!");

        PaymentIntent resource = PaymentIntent.retrieve(request.getIntentId());

        PaymentIntentConfirmParams params =
                PaymentIntentConfirmParams.builder()
                        .setReturnUrl("http://localhost:8080/payment")
                        .build();

        PaymentIntent paymentIntent = resource.confirm(params);

        return new ConfirmPaymentResponse(paymentIntent.getId(), paymentIntent.getClientSecret(), paymentIntent.getStatus());
    }

    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(@RequestBody CreatePaymentRequest request) throws StripeException {

        System.out.println("create payment intent?");

        System.out.println(request.getAmount());
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(request.getAmount() * 100L)
                        .setPaymentMethod(request.getPaymentMethod())
                        .putMetadata("userEmail",request.getEmail() )
                        .setCurrency("USD")
                        .setCustomer(request.getStripeId())
                        .setAutomaticPaymentMethods(
                                PaymentIntentCreateParams.AutomaticPaymentMethods.builder().setEnabled(true).build()
                        )
                        .build();

        PaymentIntent paymentIntent = PaymentIntent.create(params);

        return new CreatePaymentResponse(paymentIntent.getId(), paymentIntent.getClientSecret());

    }
}
