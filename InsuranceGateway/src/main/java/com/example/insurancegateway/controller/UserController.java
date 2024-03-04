package com.example.insurancegateway.controller;

import com.example.insurancegateway.domain.User;
import com.example.insurancegateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public ModelAndView loginPage(){
        ModelAndView mav = new ModelAndView("login");

        return mav;
    }

    @RequestMapping("/register")
    public ModelAndView registerPage(User user) {
        ModelAndView mav = new ModelAndView("register");

        mav.setViewName("register");
        return mav;
    }

    @RequestMapping("/registerUser")
    public ModelAndView registerUser(@ModelAttribute User user) {
        ModelAndView mav = new ModelAndView("register");

        User savedUser = userService.saveUser(user);
        if(savedUser == null){
            return mav;
        }
        mav.setViewName("redirect:login");
        return mav;
    }

}
