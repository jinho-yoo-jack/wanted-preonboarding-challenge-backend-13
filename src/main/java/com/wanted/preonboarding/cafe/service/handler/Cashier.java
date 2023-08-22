package com.wanted.preonboarding.cafe.service.handler;

import lombok.ToString;

import java.util.List;

@ToString
public class Cashier {

    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(List<Order> orders) {

        return orders.stream()
                .mapToLong(Order::getBeveragePrice)
                .sum();
    }

    private String sendTo(Barista barista, List<Order> receivedOrders) {

        return barista.makeCoffeeTo(receivedOrders);
    }

    public String takeOrder(List<Order> receivedOrders, long totalPrice) {

        cafe.plusSales(totalPrice);
        return sendTo(new Barista(0,0), receivedOrders);
    }
}
