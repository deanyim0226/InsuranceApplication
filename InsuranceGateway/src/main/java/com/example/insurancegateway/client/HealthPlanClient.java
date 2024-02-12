package com.example.insurancegateway.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HealthPlanClient {

    public JsonNode getAllHealthPlans(){

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8181/getAllHealthPlan", Object.class);

        Object obj = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode healthPlans = mapper.convertValue(obj,JsonNode.class);

        return healthPlans;
    }
}
