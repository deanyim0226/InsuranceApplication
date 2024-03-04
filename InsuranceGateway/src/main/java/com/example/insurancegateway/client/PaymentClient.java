package com.example.insurancegateway.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentClient {

    public JsonNode createPaymentIntent(JsonNode jsonNode){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(jsonNode.toString(),headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8383/create-payment-intent",request,Object.class);

        Object obj = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode clientInfo = mapper.convertValue(obj, JsonNode.class);

        return clientInfo;
    }


    public JsonNode confirmPayment(JsonNode jsonNode){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(jsonNode.toString(), headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8383/confirm-payment", request, Object.class);

        Object obj = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode clientInfo = mapper.convertValue(obj, JsonNode.class);

        return clientInfo;
    }

    public JsonNode createStripeCustomer(JsonNode jsonNode){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(jsonNode.toString(),headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8383/createCustomer", request, Object.class);

        Object obj = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode customerStripeId = mapper.convertValue(obj,JsonNode.class);

        return customerStripeId;
    }
}
