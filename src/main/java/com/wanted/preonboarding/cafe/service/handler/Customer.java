package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private Order order;

    public Customer(Order order) {
        this.order = order;
    }

    public String buyCoffee(Cashier cashier) {
        long totalPrice = cashier.calculateTotalPrice(order);
        return cashier.takeOrder(order, totalPrice);
    }
}
