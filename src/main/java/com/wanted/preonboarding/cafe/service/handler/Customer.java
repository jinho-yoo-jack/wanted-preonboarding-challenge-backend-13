package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

import java.util.List;

@Getter
public class Customer {
    private String paymentMethod;
    private final List<Order> myOrders;

    public Customer(String paymentMethod, List<Order> orders) {
        this.paymentMethod = paymentMethod;
        this.myOrders = orders;
    }

    private void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
