package com.example.insurancebilling.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Purchasing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchaseId;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Customer> customers;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate purchasedDate;
    private String healthPlanType;

    private String categoryType;

    public String getHealthPlanType() {
        return healthPlanType;
    }

    public void setHealthPlanType(String healthPlanType) {
        this.healthPlanType = healthPlanType;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(LocalDate purchasedDate) {
        this.purchasedDate = purchasedDate;
    }


}
