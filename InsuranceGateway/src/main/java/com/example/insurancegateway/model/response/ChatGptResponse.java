package com.example.insurancegateway.model.response;

import com.example.insurancegateway.model.Choice;

import java.util.List;


public class ChatGptResponse {

    private List<Choice> choices;

    public ChatGptResponse(){

    }

    public ChatGptResponse(List<Choice> choices){
        this.choices = choices;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

}
