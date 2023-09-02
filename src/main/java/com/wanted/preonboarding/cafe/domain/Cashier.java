package com.wanted.preonboarding.cafe.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Cashier {
    public long calculateTotalPrice(List<Order> orders) {
        AtomicLong totalPrice = new AtomicLong(0L);
        orders.forEach(order -> {
            totalPrice.addAndGet(order.getMenu().getAmount() * order.getCount());
        });
        return totalPrice.get();
    }

    public String sendTo(Barista barista, List<Order> receivedOrders) {
        if (!barista.isBusy()) {
            return barista.makeCoffeeTo(receivedOrders);
        }

        throw new IllegalStateException("barista is busy...");
    }
}
