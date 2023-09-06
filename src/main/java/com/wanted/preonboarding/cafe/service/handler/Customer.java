package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Customer {

    private String paymentMethod;
    private final Map<Beverage, Integer> myOrders;

    public Customer(String paymentMethod, Map<Beverage, Integer> orders) {
        this.paymentMethod = paymentMethod;
        this.myOrders = orders;
    }

    private void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String buyCoffee(Cafe cafe) {
        return cafe.takeOrder(myOrders);
    }

}
