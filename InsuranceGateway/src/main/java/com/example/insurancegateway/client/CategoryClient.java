package com.example.insurancegateway.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CategoryClient {

    public JsonNode getAllCategories(){

        RestTemplate template = new RestTemplate();

        ResponseEntity responseEntity =  template.getForEntity("http://localhost:8181/getAllCategories",Object.class);

        Object obj = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode categories = mapper.convertValue(obj, JsonNode.class);

        return categories;

    }
}
