package com.example.insurancegateway.repository;

import com.example.insurancegateway.domain.ClientClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<ClientClaim, Long> {

}
