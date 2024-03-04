package com.example.insurancebilling.model.reponse;

public class CreateCustomerResponse {

    private String stripeCustomerId;

    public CreateCustomerResponse(String id){
        this.stripeCustomerId = id;
    }

    public String getStripeCustomerId() {
        return stripeCustomerId;
    }

    public void setStripeCustomerId(String stripeCustomerId) {
        this.stripeCustomerId = stripeCustomerId;
    }


}
