package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public String takeOrder(Order order) {
        cafe.plusSales(order.calculateTotalPrice());
        Barista barista = new Barista(0, 0);
        return barista.makeCoffeeTo(order);
    }
}
