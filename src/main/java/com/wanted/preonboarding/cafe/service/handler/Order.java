package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.Menu;
import lombok.Getter;

import java.util.Map;

@Getter
public class Order {
    private final Map<Menu,Integer> order;
    private final Long totalPrice;

    public Order(Map<Menu, Integer> order) {
        this.order = order;
        this.totalPrice = calculateTotalPrice(order);
    }

    private long calculateTotalPrice(Map<Menu, Integer> orders) {
        long totalPrice = 0L;
        for (Menu menu : orders.keySet()) {
            totalPrice += (long) menu.getPrice() * orders.get(menu);
        }
        return totalPrice;
    }
}
