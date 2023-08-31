package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

import java.util.Map;

@Getter
public class Customer {
    private PayType paymentMethod;
    private final Map<String, Integer> items;

    public Customer(PayType paymentMethod, Map<String, Integer> ItemQuantity) {
        this.paymentMethod = paymentMethod;
        this.items = ItemQuantity;
    }

    private void setPaymentMethod(PayType paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
