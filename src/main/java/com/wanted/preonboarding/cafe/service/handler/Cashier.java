package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Cashier {

    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(Map<String, Integer> orders) {
        int totalPrice = 0;
        for (String order: orders.keySet()) {
            totalPrice += cafe.getPriceOf(order);
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
