package com.wanted.preonboarding.cafe.service.handler;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    private String sendTo(Barista barista, OrderTable orderTable) {
        return barista.makeCoffeeTo(orderTable);
    }

    public String takeOrder(OrderTable orderTable) {
        cafe.plusSales(orderTable.calculateTotalPrice());
        return sendTo(new Barista(0,0), orderTable);
    }
}
