package com.example.insurancemicroservice.domain;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;
    private String description;
    private String feature;
    private double deductible;
    private double coPayment;
    private double maxOutOfPocket;
    private double price;


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public double getDeductible() {
        return deductible;
    }

    public void setDeductible(double deductible) {
        this.deductible = deductible;
    }

    public double getCoPayment() {
        return coPayment;
    }

    public void setCoPayment(double coPayment) {
        this.coPayment = coPayment;
    }

    public double getMaxOutOfPocket() {
        return maxOutOfPocket;
    }

    public void setMaxOutOfPocket(double maxOutOfPocket) {
        this.maxOutOfPocket = maxOutOfPocket;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }






}
