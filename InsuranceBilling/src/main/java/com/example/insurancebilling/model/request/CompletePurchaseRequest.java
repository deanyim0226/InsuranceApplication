package com.example.insurancebilling.model.request;

import com.example.insurancebilling.domain.Address;
import com.example.insurancebilling.domain.Customer;

public class CompletePurchaseRequest {

    private Customer customer;
    private Address address;

    private Long categoryId;
    private Long planId;

}
