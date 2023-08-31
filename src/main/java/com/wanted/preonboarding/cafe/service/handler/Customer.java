package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Customer {
    private String paymentMethod;
    private final Map<String, Integer> myOrders;

    public Customer(String paymentMethod, Map<String, Integer> orders) {
        this.paymentMethod = paymentMethod;
        this.myOrders = orders;
    }

    public String buyCoffee(Cafe cafe) {
        long totalPrice = cafe.getCashier().calculateTotalPrice(cafe, myOrders);
        return cafe.getCashier().takeOrder(cafe, myOrders, totalPrice);
    }
}
