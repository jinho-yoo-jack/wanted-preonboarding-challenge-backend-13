package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class CustomerService {

    public Customer createCustomer(String paymentMethod, Map<String, Integer> orders) {

        return new Customer(paymentMethod, orders);
    }
}
