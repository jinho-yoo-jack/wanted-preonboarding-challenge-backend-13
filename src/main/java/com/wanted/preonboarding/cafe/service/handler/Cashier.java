package com.wanted.preonboarding.cafe.service.handler;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    private String sendTo(Barista barista, Order receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    public String takeOrder(Order receivedOrders) {
        cafe.plusSales(receivedOrders.getTotalPrice());
        return sendTo(new Barista(0,0), receivedOrders);
    }
}
