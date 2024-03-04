package com.example.insurancebilling.repository;

import com.example.insurancebilling.domain.Purchasing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchasing,Long> {

}
