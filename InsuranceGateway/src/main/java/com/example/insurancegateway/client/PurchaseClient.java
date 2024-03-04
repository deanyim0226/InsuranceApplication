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
public class PurchaseClient {

    public JsonNode savePurchase(JsonNode purchase){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(purchase.toString(), headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8383/savePurchasing", request,Object.class);

        Object obj = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode savedCustomer = mapper.convertValue(obj, JsonNode.class);


        return savedCustomer;

    }

    public JsonNode getPurchase(Long purchaseId){

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:8383/getPurchaseById/"+purchaseId, Object.class);

        Object obj = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode retrievedPurchase = mapper.convertValue(obj, JsonNode.class);

        return retrievedPurchase;
    }
}
