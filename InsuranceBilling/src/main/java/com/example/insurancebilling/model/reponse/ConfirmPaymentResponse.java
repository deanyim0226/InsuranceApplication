package com.example.insurancebilling.model.reponse;

public class ConfirmPaymentResponse {

    private String intentId;
    private String clientSecret;

    private String status;

    public ConfirmPaymentResponse(String intentId, String clientSecret, String status){
        this.clientSecret = clientSecret;
        this.intentId = intentId;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
