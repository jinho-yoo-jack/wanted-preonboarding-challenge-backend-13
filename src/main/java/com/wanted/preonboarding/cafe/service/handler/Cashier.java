package com.wanted.preonboarding.cafe.service.handler;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public String takeOrder(Orders receivedOrders) {
        cafe.plusSales(receivedOrders.getTotalPrice());
        return sendTo(new Barista(0,0), receivedOrders);
    }

    private String sendTo(Barista barista, Orders receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }
}
