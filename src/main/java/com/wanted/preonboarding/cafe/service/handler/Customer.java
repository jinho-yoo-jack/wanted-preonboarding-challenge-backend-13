package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

import java.util.Map;

@Getter
public class Customer {
    private final String name;
    private Payment payment;
    private final Orders myOrders;

    public Customer(String name, Payment payment, Orders orders) {
        this.name = name;
        this.payment = payment;
        this.myOrders = orders;
    }

    private void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String buyCoffee(Cashier cashier, long totalPrice) {
        return cashier.takeOrder(myOrders, totalPrice);
    }
}
