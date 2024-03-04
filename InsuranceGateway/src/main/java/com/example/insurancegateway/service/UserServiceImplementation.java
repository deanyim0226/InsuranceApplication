package com.example.insurancegateway.service;



import com.example.insurancegateway.domain.User;
import com.example.insurancegateway.repository.UserRepository;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;



    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public User saveUser(User newUser) {
        /*
        security required for encrypted password
         */
        String encryptedPassword = encoder.encode(newUser.getPassword());
        newUser.setPassword(encryptedPassword);

        List<User> userList = userRepository.findAll();
        newUser.setUserId(Long.valueOf(userList.size()+1));
        User admin = userList.get(1);
        User customer = userList.get(0);

        newUser.setRoles(customer.getRoles());
        System.out.println(newUser.getUserId());

        System.out.println("saving user");
        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(User existedUser) {

        try(Session session = sessionFactory.openSession();){

            session.beginTransaction();

            session.getTransaction().commit();


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.getById(userId);
    }

    @Override
    public User findUserByName(String userName) {
        String hql = "From User where username = :param";

        try(Session session = sessionFactory.openSession();){
            session.beginTransaction();

            Query query = session.createQuery(hql);
            query.setParameter("param",userName);
            User user = (User)query.getResultList().get(0);
            session.getTransaction().commit();

            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
