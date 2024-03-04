package com.example.insurancemicroservice.service;

import com.example.insurancemicroservice.domain.Category;
import com.example.insurancemicroservice.domain.CategoryType;
import com.example.insurancemicroservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }


    public Category getCategoryByType(String categoryType){

        return categoryRepository.getCategoryByCategoryType(CategoryType.valueOf(categoryType));
    }
}
