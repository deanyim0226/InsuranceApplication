package com.example.insurancegateway.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Component
public class InsuranceClient {


    public JsonNode getAllInsurances(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:8181/getAllInsurances",Object.class);

        Object obj = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode insurances = mapper.convertValue(obj,JsonNode.class);

        return insurances;
    }

    public JsonNode getInsurance(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:8181/getInsurance",Object.class);

        Object obj = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode insurances = mapper.convertValue(obj,JsonNode.class);

        return insurances;
    }
}
