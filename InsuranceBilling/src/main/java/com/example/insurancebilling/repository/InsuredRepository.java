package com.example.insurancebilling.repository;

import com.example.insurancebilling.domain.Insured;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuredRepository extends JpaRepository<Insured,Long> {
}
