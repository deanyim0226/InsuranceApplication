package com.example.insurancebilling.domain;


import jakarta.persistence.*;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long policyId;
    private String description;

    @OneToOne
    private Insured insured;

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }


}
