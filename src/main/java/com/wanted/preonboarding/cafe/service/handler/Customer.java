package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Customer {
    private PaymentMethod paymentMethod;
    private final Map<String, Integer> myOrders;

    public Customer(PaymentMethod paymentMethod, Map<String, Integer> orders) {
        this.paymentMethod = paymentMethod;
        this.myOrders = orders;
    }

    private void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String buyCoffee(Cashier cashier) {
        return cashier.takeOrder(myOrders);
    }
}
