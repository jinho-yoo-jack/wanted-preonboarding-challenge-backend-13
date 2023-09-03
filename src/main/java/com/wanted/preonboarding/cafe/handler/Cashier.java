package com.wanted.preonboarding.cafe.handler;

import com.wanted.preonboarding.cafe.entity.Menu;

import java.util.Map;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(Map<Menu, Integer> orders) {
        long totalPrice = 0L;
        for (Menu key : orders.keySet()) {
            totalPrice += key.getPrice() * orders.get(key);
        }
        return totalPrice;
    }

    private String sendTo(Barista barista, Map<Menu, Integer> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    public String takeOrder(Map<Menu, Integer> receivedOrders, long totalPrice) {
        cafe.plusSales(totalPrice);
        return sendTo(new Barista(0,0), receivedOrders);
    }
}
