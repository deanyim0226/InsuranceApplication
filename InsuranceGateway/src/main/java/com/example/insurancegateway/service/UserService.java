package com.example.insurancegateway.service;

import com.example.insurancegateway.domain.User;

import java.util.List;

public interface UserService {

    public User saveUser(User newUser);
    public User updateUser(User existedUser);
    public List<User> getUsers();
    public void deleteUser(Long userId);
    public User getUserById(Long userId);

    public User findUserByName(String userName);

}
