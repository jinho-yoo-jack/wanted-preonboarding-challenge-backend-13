package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.entity.Order;
import com.wanted.preonboarding.cafe.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class Barista {
    private int rank; // 0: Beginner 1: Middle 2: Master
    private int status; // 0: Waiting 1: Making

    public String makeCoffeeTo(Orders orders) {
        StringBuilder makeOrders = new StringBuilder();
        for (Order order : orders.getOrderList()) {
            makeOrders.append(order.getDrinks().name())
                .append(":").append(order.getAmount()).append("\n");
        }
        return makeOrders.toString();
    }
}
