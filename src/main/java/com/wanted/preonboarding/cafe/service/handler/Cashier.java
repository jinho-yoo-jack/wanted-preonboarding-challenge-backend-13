package com.wanted.preonboarding.cafe.service.handler;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }


    private String sendTo(Barista barista, CaffeOrders receivedCaffeOrders) {
        return barista.makeCoffeeTo(receivedCaffeOrders);
    }

    public String takeOrder(CaffeOrders receivedOrders) {
        cafe.plusSales(receivedOrders.calculateTotalPrice());
        return sendTo(new Barista(0,0), receivedOrders);
    }
}
