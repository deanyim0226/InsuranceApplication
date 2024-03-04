package com.example.insurancebilling.domain;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Insured {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long insuredId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfEffective;


    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    private Purchasing purchasing;



    public Long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(Long insuredId) {
        this.insuredId = insuredId;
    }

    public LocalDate getDateOfEffective() {
        return dateOfEffective;
    }

    public void setDateOfEffective(LocalDate dateOfEffective) {
        this.dateOfEffective = dateOfEffective;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Purchasing getPurchasing() {
        return purchasing;
    }

    public void setPurchasing(Purchasing purchasing) {
        this.purchasing = purchasing;
    }



}
