package com.example.insurancemicroservice.repository;


import com.example.insurancemicroservice.domain.HealthInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthInsuranceRepository extends JpaRepository<HealthInsurance,Long> {
}
