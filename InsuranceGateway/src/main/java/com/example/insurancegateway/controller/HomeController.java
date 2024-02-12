package com.example.insurancegateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {


    @RequestMapping({"/home", "/"})
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView("home");

        return mav;
    }

    @RequestMapping("/blog")
    public ModelAndView blog(){
        ModelAndView mav = new ModelAndView("blog");

        return mav;
    }

    @RequestMapping("/blogDetails")
    public ModelAndView blog_details(){
        ModelAndView mav = new ModelAndView("blogDetails");

        return mav;
    }

    @RequestMapping("/contactUs")
    public ModelAndView contact_us(){
        ModelAndView mav = new ModelAndView("contactUs");

        return mav;
    }

    @RequestMapping("/address")
    public ModelAndView addressPage(){
        ModelAndView mav = new ModelAndView("address");

        mav.addObject("plans", List.of("EPO","HMO","POS","PPO"));


        return mav;
    }

    @RequestMapping("/userInfo")
    public ModelAndView userInfoPage(){
        ModelAndView mav = new ModelAndView("userInfo");

        mav.addObject("plans", List.of("EPO","HMO","POS","PPO"));


        return mav;
    }

    @RequestMapping("/plan")
    public ModelAndView planPage(){
        ModelAndView mav = new ModelAndView("plan");

        mav.addObject("plans", List.of("EPO","HMO","POS","PPO"));


        return mav;
    }

    @RequestMapping("/category")
    public ModelAndView categoryPage(){
        ModelAndView mav = new ModelAndView("category");

        mav.addObject("plans", List.of("EPO","HMO","POS","PPO"));


        return mav;
    }
}
