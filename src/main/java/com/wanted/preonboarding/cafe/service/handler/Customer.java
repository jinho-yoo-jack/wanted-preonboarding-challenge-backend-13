package com.wanted.preonboarding.cafe.service.handler;

import lombok.ToString;

import java.util.List;

@ToString
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

    public String buyCoffee(Cashier cashier) {

        long totalPrice = cashier.calculateTotalPrice(myOrders);
        return cashier.takeOrder(myOrders, totalPrice);
    }
}
