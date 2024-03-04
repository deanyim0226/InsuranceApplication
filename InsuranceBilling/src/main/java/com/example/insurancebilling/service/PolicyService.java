package com.example.insurancebilling.service;

import com.example.insurancebilling.domain.Policy;
import com.example.insurancebilling.repository.PolicyRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

    @Autowired
    PolicyRepository policyRepository;

    @Autowired
    SessionFactory sessionFactory;
    public Policy savePolicy(Policy policy){

        return policyRepository.save(policy);
    }

    public Policy getPolicyById(Long policyId){
        return policyRepository.findById(policyId).orElse(null);
    }

    public Policy updatePolicy(Policy policy){

        try(Session session = sessionFactory.openSession()){

            session.beginTransaction();
            Policy retrievedPolicy = session.get(Policy.class,policy.getPolicyId());
            session.update(retrievedPolicy);
            session.getTransaction().commit();

            return retrievedPolicy;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
