package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(HashMap<String, Item> storage, Map<String, Integer> orders) {
        long totalPrice = 0L;
        for (String key : orders.keySet()) {
            totalPrice += storage.get(key).getPrice() * orders.get(key); //price * quantity
        }
        return totalPrice;
    }

    private String sendTo(Barista barista, Map<String, Integer> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    public String takeOrder(Map<String, Integer> receivedOrders, long totalPrice) {
        cafe.plusSales(totalPrice);
        return sendTo(new Barista(0,0), receivedOrders);
    }
}
