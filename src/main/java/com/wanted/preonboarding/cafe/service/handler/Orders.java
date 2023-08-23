package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

public record Orders(Map<Menu, Integer> orderItems) {

    public Orders() {
        this(new HashMap<>());
    }

    public Orders addOrder(Menu menu, int quantity) {
        Map<Menu, Integer> newOrderItems = new HashMap<>(orderItems);
        newOrderItems.put(menu, quantity);
        return new Orders(newOrderItems);
    }

    public Map<Menu, Integer> getOrderItems() {
        return orderItems;
    }
}
