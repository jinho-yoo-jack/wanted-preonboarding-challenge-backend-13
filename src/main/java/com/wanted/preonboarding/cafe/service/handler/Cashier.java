package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(Map<String, Integer> orders) {
        long totalPrice = 0L;
        for (String key : orders.keySet()){
            long price = cafe.getMenuPrice(key);
            int quantity = orders.get(key);
            totalPrice += price * quantity;
        }
        return totalPrice;
    }

    private String sendTo(Map<String, Integer> receivedOrders) {
        return cafe.getKitchen().makeBeverage(receivedOrders);
    }

    public String takeOrder(Map<String, Integer> receivedOrders) {
        cafe.plusSales(calculateTotalPrice(receivedOrders));
        return sendTo(receivedOrders);
    }
}
