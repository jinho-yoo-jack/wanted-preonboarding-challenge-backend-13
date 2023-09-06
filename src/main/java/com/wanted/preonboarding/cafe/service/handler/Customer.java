package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Customer {
    private String paymentMethod;
    private final Map<Drink, Integer> myOrders;

    public Customer(String paymentMethod, Map<Drink, Integer> orders) {
        this.paymentMethod = paymentMethod;
        this.myOrders = orders;
    }

    private void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String buyCoffee(String coffee) {
        return coffee;
    }
}
