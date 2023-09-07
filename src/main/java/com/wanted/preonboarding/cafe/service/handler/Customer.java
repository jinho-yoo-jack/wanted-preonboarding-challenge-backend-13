package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Customer {
    private String paymentMethod;
    private final Cashier cashier;
    private final Map<Beverage, Integer> myOrders;

    public Customer(String p, Map<Beverage, Integer> o, Cashier c) {
        this.paymentMethod = p;
        this.myOrders = o;
        this.cashier = c;
    }

    private void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String buy() {
        long totalPrice = cashier.calculateTotalPrice(myOrders);
        return cashier.takeOrder(myOrders, totalPrice);
    }
}
