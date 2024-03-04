package com.example.insurancebilling.service;

import com.example.insurancebilling.domain.Insured;
import com.example.insurancebilling.repository.InsuredRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuredService {

    @Autowired
    InsuredRepository insuredRepository;

    @Autowired
    SessionFactory sessionFactory;

    public Insured saveInsured(Insured insured){

        return insuredRepository.save(insured);
    }

    public Insured updateInsured(Insured clientInsured){

        if(clientInsured == null){
            return null;
        }else{

            String hql = "From Insured";

            try(Session session = sessionFactory.openSession()){

                session.beginTransaction();

                List<Insured> insuredList = session.createQuery(hql).list();

                if(insuredList.isEmpty()){
                    return null;
                }

                Insured selectedInsured = null;

                for(Insured insured : insuredList ){
                    if(insured.getPurchasing().getPurchaseId().equals(clientInsured.getPurchasing().getPurchaseId())){
                        selectedInsured = insured;
                        break;
                    }
                }

                if(selectedInsured == null){
                    return null;
                }


                Insured retrievedInsured = session.get(Insured.class, selectedInsured.getInsuredId());

                retrievedInsured.setDateOfEffective(clientInsured.getDateOfEffective());
                retrievedInsured.setStatus(clientInsured.getStatus());

                session.update(retrievedInsured);
                session.getTransaction().commit();

                return retrievedInsured;

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return null;
    }

}
