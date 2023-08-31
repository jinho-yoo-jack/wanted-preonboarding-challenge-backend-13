package com.wanted.preonboarding.cafe.service.handler;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(Order order) {
        return order.calculateTotalPrice();
    }

    private String sendTo(Barista barista, Order receivedOrder) {
        return barista.makeCoffee(receivedOrder);
    }

    public String takeOrder(Order receivedOrder, long totalPrice) {
        cafe.plusSales(totalPrice);
        return sendTo(new Barista(Barista.Rank.BEGINNER, Barista.Status.WAITING), receivedOrder);
    }
}
