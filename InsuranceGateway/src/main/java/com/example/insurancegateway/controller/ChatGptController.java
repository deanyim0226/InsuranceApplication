package com.example.insurancegateway.controller;

import com.example.insurancegateway.model.request.ChatGptRequest;
import com.example.insurancegateway.model.response.ChatGptResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ChatGptController {

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Value("${openai.api.key}")
    private String apiKey;

    @PostMapping ("/chat")
    public ModelAndView chat(@RequestParam("prompt") String prompt){

        ModelAndView mav = new ModelAndView("chat");

        ChatGptRequest gptRequest = new ChatGptRequest(model,prompt);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        HttpEntity<ChatGptRequest> request = new HttpEntity<>(gptRequest, headers);

        RestTemplate restTemplate = new RestTemplate();

        ChatGptResponse response = restTemplate.postForObject(apiUrl,request,ChatGptResponse.class);

        if(response.getChoices().get(0).getMessage().getContent().length() > 0){
            mav.addObject("answered",true);
            mav.addObject("answer", response.getChoices().get(0).getMessage().getContent());

        }
        System.out.println(response.getChoices().get(0).getMessage().getContent());

        return mav;
    }
}
