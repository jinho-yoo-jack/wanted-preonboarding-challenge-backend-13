package com.wanted.preonboarding.cafe.service.handler;

import java.util.List;

public class Customer {
    private PaymentMethod paymentMethod;
    private final List<Order> orders;

    public Customer(PaymentMethod paymentMethod, List<Order> orders) {
        this.paymentMethod = paymentMethod;
        this.orders = orders;
    }

    public String buyCoffee(Cashier cashier) {
        long totalPrice = cashier.calculateTotalPrice(orders);
        return cashier.takeOrder(orders, totalPrice);
    }
}
