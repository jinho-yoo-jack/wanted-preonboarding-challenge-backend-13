package com.wanted.preonboarding.cafe.service.handler;

import java.util.List;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(List<Order> orders) {
        long totalPrice = 0L;
        for (Order order : orders) {
            totalPrice += order.getMenu().getPrice();
        }
        return totalPrice;
    }

    private String sendTo(Barista barista, List<Order> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    public String takeOrder(List<Order> receivedOrders, long totalPrice) {
        cafe.plusSales(totalPrice);
        return sendTo(new Barista(0,0), receivedOrders);
    }
}
