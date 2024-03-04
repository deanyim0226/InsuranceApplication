package com.example.insurancegateway.controller;


import com.example.insurancegateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuoteController {


    @Autowired
    UserService userService;



}
