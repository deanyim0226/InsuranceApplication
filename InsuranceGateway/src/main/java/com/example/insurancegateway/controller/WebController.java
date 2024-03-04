package com.example.insurancegateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WebController {

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

    @RequestMapping("/quote")
    public ModelAndView quotePage(){
        ModelAndView mav = new ModelAndView("quote");
        mav.addObject("genders", List.of("MALE","FEMALE"));

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

        mav.addObject("genders", List.of("MALE","FEMALE"));

        return mav;
    }

    @RequestMapping("/plan")
    public ModelAndView planPage(){
        ModelAndView mav = new ModelAndView("plan");

        mav.addObject("plans", List.of("EPO","HMO","POS","PPO"));


        return mav;
    }


    @RequestMapping("/review")
    public ModelAndView categoryPage(){
        ModelAndView mav = new ModelAndView("review");


        return mav;
    }

    @RequestMapping("/payment")
    public ModelAndView paymentPage(){
        ModelAndView mav = new ModelAndView("payment");


        return mav;
    }

    @RequestMapping("/complete")
    public ModelAndView completePage(){
        ModelAndView mav = new ModelAndView("complete");


        return mav;
    }


    @RequestMapping("/claim")
    public ModelAndView claimPage(){
        ModelAndView mav = new ModelAndView("claim");


        return mav;
    }

    @RequestMapping("/document")
    public ModelAndView documentPage(){
        ModelAndView mav = new ModelAndView("document");

        return mav;
    }


    @RequestMapping("/profile")
    public ModelAndView profilePage(){
        ModelAndView mav = new ModelAndView("profile");

        return mav;
    }


    @RequestMapping("/chat")
    public ModelAndView chatPage(){
        ModelAndView mav = new ModelAndView("chat");

        return mav;
    }

    @RequestMapping("/management")
    public ModelAndView managementPage(){
        ModelAndView mav = new ModelAndView("management");

        return mav;
    }

    @RequestMapping("/insurance")
    public ModelAndView insurancePage(){
        ModelAndView mav = new ModelAndView("insurance");

        return mav;
    }
}
