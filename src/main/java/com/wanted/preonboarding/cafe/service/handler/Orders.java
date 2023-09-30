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

    public long calculateTotalPrice(Payment payment) {
        long totalPrice = 0L;
        Map<Menu, Integer> orderItems = this.getOrderItems();
        for (Map.Entry<Menu, Integer> entry : orderItems.entrySet()) {
            Menu menu = entry.getKey();
            Integer quantity = entry.getValue();
            totalPrice += (long) menu.getPrice() * quantity;
        }
        return totalPrice;
    }
}
