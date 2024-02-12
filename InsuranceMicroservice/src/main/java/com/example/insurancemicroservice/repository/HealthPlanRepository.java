package com.example.insurancemicroservice.repository;


import com.example.insurancemicroservice.domain.HealthPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthPlanRepository extends JpaRepository<HealthPlan,Long> {
}
