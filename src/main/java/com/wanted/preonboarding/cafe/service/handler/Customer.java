package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.entity.Order;

public class Customer {
    private String paymentMethod;
    private final Order myOrders;

    public Customer(String paymentMethod, Order orders) {
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
