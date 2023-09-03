package com.wanted.preonboarding.cafe.domain;

import java.util.List;
import org.springframework.stereotype.Component;

public class Cafe {
    private final String name;
    private Cashier cashier;
    private Barista barista;
    private Long sales;

    public Cafe(Cashier cashier, Barista barista) {
        this();
        this.barista = barista;
        this.cashier = cashier;
    }

    private Cafe() {
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
    }

    public void takeOrder(List<OrderMenu> receivedOrders) {
        final long totalPrice = cashier.calculateTotalPrice(receivedOrders);

        plusSales(totalPrice);
    }

    public String sendTo(List<OrderMenu> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    private void plusSales(Long amount) {
        this.sales += amount;
    }

    public Long getSales() {
        return sales;
    }
}
