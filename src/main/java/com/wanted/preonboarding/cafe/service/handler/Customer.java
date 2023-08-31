package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String paymentMethod;
    private final Map<String, Integer> orders;

    public Customer(String paymentMethod, Map<String, Integer> orders) {
        this.paymentMethod = paymentMethod;
        this.orders = orders;
    }

    private void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String buyCoffee(Cashier cashier) {
        long totalPrice = cashier.calculateTotalPrice(orders);
        return cashier.takeOrder(orders, totalPrice);
    }
}
