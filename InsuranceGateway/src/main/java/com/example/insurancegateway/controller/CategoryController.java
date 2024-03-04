package com.example.insurancegateway.controller;

import com.example.insurancegateway.client.CategoryClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    CategoryClient categoryClient;

    @GetMapping("getAllCategories")
    public JsonNode getAllCategories(){
        System.out.println("category all is called");

        return categoryClient.getAllCategories();
    }

    @GetMapping("getCategoryByType/{categoryType}")
    public JsonNode getCategoryByType(@PathVariable String categoryType){
        return categoryClient.getCategoryByType(categoryType);
    }
}
