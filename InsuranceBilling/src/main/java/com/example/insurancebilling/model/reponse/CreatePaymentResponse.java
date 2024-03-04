package com.example.insurancebilling.model.reponse;

public class CreatePaymentResponse {

    private String intentId;
    private String clientSecret;


    public CreatePaymentResponse(String intentId, String clientSecret){
        this.clientSecret = clientSecret;
        this.intentId = intentId;
    }

    public String getIntentId() {
        return intentId;
    }

    public void setIntentId(String intentId) {
        this.intentId = intentId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

}
