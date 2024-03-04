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
public class CustomerClient {

    public JsonNode saveCustomer(JsonNode customer){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(customer.toString(), headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8383/saveCustomer", request,Object.class);

        Object obj = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode savedCustomer = mapper.convertValue(obj, JsonNode.class);


        return savedCustomer;

    }
}
