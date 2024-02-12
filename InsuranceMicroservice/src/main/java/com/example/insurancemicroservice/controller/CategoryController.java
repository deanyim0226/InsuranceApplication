package com.example.insurancemicroservice.controller;


import com.example.insurancemicroservice.domain.Category;
import com.example.insurancemicroservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("getAllCategories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
