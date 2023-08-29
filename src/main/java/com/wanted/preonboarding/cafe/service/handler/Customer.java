package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String paymentMethod;
    private final Map<String, Integer> myOrders;

    public Customer(String paymentMethod, Map<String, Integer> orders) {
        this.paymentMethod = paymentMethod;
        this.myOrders = orders;
    }

    private void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String buyCoffee(Cashier cashier) {
        return cashier.takeOrder(myOrders);
    }
}
