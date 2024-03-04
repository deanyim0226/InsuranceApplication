package com.example.insurancebilling;

import com.stripe.Stripe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InsuranceBillingApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceBillingApplication.class, args);


    }

}

/*

Task 3 - Once payment is completed,
send an email to the user with a link to upload the documents.
A user will upload the document.

health insurance
document
-> hospital bill
-> doctor note

Create a admin page to display all the insurance request,
he will verify all the document and if he feels everything is fine
he will approve the policy and then email will trigger on the registered email id with policy document

Task4

Implement Claim Microservice

Claim Intimation - Intimate to the company that yu met an accident and upload mishap images
Raise A Claim - Bumper Replaced - 100$, Car Tail Ligth - 20$, Tyre was changed - 30$
Claim Approval - 100 - 90


 */