package com.example.insurancegateway.service;



import com.example.insurancegateway.domain.User;
import com.example.insurancegateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User newUser) {
        /*
        security required for encrypted password
         */

        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(User existedUser) {


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
}
