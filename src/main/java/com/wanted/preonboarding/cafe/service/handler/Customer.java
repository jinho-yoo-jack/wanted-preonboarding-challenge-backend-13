package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String paymentMethod;
    private final Order order;

    public Customer(String paymentMethod, Order orders) {
        this.paymentMethod = paymentMethod;
        this.order = orders;
    }

    private void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String buyCoffee(Cashier cashier) {
        return cashier.takeOrder(order);
    }
}
