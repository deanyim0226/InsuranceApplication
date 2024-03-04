package com.example.insurancegateway.model.request;

import com.example.insurancegateway.model.Message;

import java.util.ArrayList;
import java.util.List;


public class ChatGptRequest {

    private String model;

    private List<Message> messages;

    public ChatGptRequest(String model, String prompt){
        this.model= model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user",prompt));
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }


}
