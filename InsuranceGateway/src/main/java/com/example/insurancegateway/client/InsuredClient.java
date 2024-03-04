package com.example.insurancegateway.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Component
public class InsuredClient{


    public JsonNode saveInsured(JsonNode insured){
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(insured.toString(),headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8383/saveInsured",request,Object.class);

        Object obj = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode savedInsured = mapper.convertValue(obj,JsonNode.class);

        return savedInsured;
    }
    public JsonNode updateInsured(JsonNode insured){

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(insured.toString(),headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8383/updateInsured",request,Object.class);

        Object obj = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode updatedInsured = mapper.convertValue(obj,JsonNode.class);

        return updatedInsured;

    }
}
