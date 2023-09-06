package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Cashier {

    public long calculateTotalPrice(Map<Drink, Integer> orders) {
        long totalPrice = 0L;
        for (Drink drink : orders.keySet()) {
            totalPrice += drink.getPrice() * orders.get(drink);
        }
        return totalPrice;
    }

    private String sendTo(Barista barista, Map<Drink, Integer> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    public String takeOrder(Map<Drink, Integer> receivedOrders) {
        return sendTo(new Barista(0,0), receivedOrders);
    }
}
