package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
public class Customer {
    private String paymentMethod;
    private Map<String, Long> myOrders;

    public Customer(Map<String, Long> myOrders) {
        this.paymentMethod = "Card";
        this.myOrders = myOrders;
    }
}
