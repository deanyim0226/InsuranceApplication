package com.example.insurancegateway.service;

import com.example.insurancegateway.domain.ClientClaim;
import com.example.insurancegateway.domain.ClientDocument;
import com.example.insurancegateway.domain.Status;
import com.example.insurancegateway.repository.ClaimRepository;
import com.stripe.model.tax.Registration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {

    @Autowired
    ClaimRepository claimRepository;

    @Autowired
    SessionFactory sessionFactory;

    public ClientClaim updateClaim(Long claimId, String status){


        try(Session session = sessionFactory.openSession())
        {
            session.beginTransaction();
            ClientClaim retrievedClaim = session.get(ClientClaim.class,claimId);
            retrievedClaim.setStatus(Status.valueOf(status));
            session.update(retrievedClaim);
            session.getTransaction().commit();

            return retrievedClaim;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ClientClaim saveClaim(ClientClaim clientClaim){

        return claimRepository.save(clientClaim);
    }

    public List<ClientClaim> getAll(){
        return claimRepository.findAll();
    }

    public ClientClaim getClaim(Long id){
        return claimRepository.findById(id).orElse(null);
    }
}
