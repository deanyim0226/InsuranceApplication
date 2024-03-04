package com.example.insurancegateway.service;

import com.example.insurancegateway.domain.ClientDocument;
import com.example.insurancegateway.domain.Status;
import com.example.insurancegateway.repository.DocumentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    SessionFactory sessionFactory;

    public ClientDocument saveClientDocument(ClientDocument clientDocument){
        return documentRepository.save(clientDocument);
    }

    public ClientDocument getClientDocument(String fileName){
        return documentRepository.findByFileName(fileName);
    }

    public ClientDocument updateClientDocument(Long id, String status){

        ClientDocument clientDocument = documentRepository.findById(id).orElse(null);

        if(clientDocument != null){

            try(Session session = sessionFactory.openSession()){
                session.beginTransaction();
                clientDocument.setStatus(Status.valueOf(status));
                session.update(clientDocument);
                session.getTransaction().commit();

                return clientDocument;

            }catch (Exception e){
                e.printStackTrace();
            }
        }


        return null;
    }

    public List<ClientDocument> getAll(){
        return documentRepository.findAll();
    }
    public ClientDocument getDocument(Long id){
        return documentRepository.findById(id).orElse(null);
    }
}
