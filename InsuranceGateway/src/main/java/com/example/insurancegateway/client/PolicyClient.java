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
public class PolicyClient {


    public JsonNode savePolicy(JsonNode policy){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(policy.toString(), headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8383/savePolicy", entity, Object.class);

        Object obj = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode savedPolicy = mapper.convertValue(obj, JsonNode.class);

        return savedPolicy;
    }

    public JsonNode updatePolicy(JsonNode policy){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(policy.toString(), headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8383/updatePolicy",entity, Object.class);

        Object obj = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode updatedPolicy = mapper.convertValue(obj, JsonNode.class);
        return updatedPolicy;
    }
    public JsonNode getPolicyById(Long policyId){


        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:8383/getPolicyById/"+policyId, Object.class);

        Object obj = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode retrievedPolicy = mapper.convertValue(obj, JsonNode.class);

        return retrievedPolicy;
    }
}
