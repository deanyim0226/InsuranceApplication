package com.example.insurancegateway.repository;

import com.example.insurancegateway.domain.ClientDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentRepository extends JpaRepository<ClientDocument,Long> {

    ClientDocument findByFileName(String fileName);
}
