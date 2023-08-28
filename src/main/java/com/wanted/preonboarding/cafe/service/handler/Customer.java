package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.entity.Drinks;
import com.wanted.preonboarding.cafe.entity.Order;
import com.wanted.preonboarding.cafe.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class Customer {
    private String paymentMethod;
    private final Orders myOrders;

    public String buyCoffee(Cashier cashier) {
        long totalPrice = cashier.calculateTotalPrice(myOrders);
        return cashier.takeOrder(myOrders, totalPrice);
    }
}
