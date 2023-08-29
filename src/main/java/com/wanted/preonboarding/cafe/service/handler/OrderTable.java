package com.wanted.preonboarding.cafe.service.handler;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrderTable {
    private final List<Order> orders;

    public long calculateTotalPrice() {
        return orders.stream()
                .mapToLong(Order::orderPrice)
                .sum();
    }

    public String makeCoffeeTo(){
        StringBuilder makeOrders = new StringBuilder();
        for(Order order : orders){
            int quantity = order.quantity();
            makeOrders.append(order.menu().name())
                    .append(":")
                    .append(quantity);
        }
        return makeOrders.toString();
    }
}
