package com.example.insurancemicroservice.repository;


import com.example.insurancemicroservice.domain.HealthPlan;
import com.example.insurancemicroservice.domain.PlanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthPlanRepository extends JpaRepository<HealthPlan,Long> {

    public HealthPlan findByPlanType(PlanType planType);
}
