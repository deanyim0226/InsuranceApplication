package com.example.insurancemicroservice.domain;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class HealthInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insuranceId;

    private String insuranceName;

    @OneToMany(fetch = FetchType.EAGER)
    private List<HealthPlan> Plans; //one to many

    public Long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public List<HealthPlan> getPlans() {
        return Plans;
    }

    public void setPlans(List<HealthPlan> plans) {
        Plans = plans;
    }


}
