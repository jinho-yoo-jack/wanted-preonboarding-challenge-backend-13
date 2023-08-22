package com.wanted.preonboarding.cafe.service.handler;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public void takeOrder(long totalPrice) {
        cafe.plusSales(totalPrice);
    }
}
