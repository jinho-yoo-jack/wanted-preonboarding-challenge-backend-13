package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;


@Getter
public class Customer {
    private String name;
    private Payment payment;
    private Orders myOrders;

    public Customer(String name, Payment payment, Orders orders) {
        this.name = name;
        this.payment = payment;
        this.myOrders = orders;
    }

    private void setPayment(Payment payment) {
        this.payment = payment;
    }

}
