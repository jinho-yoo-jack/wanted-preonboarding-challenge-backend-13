package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.domain.Order;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(List<Order> orders) {
        AtomicLong totalPrice = new AtomicLong(0L);
        orders.forEach(order -> {
            totalPrice.addAndGet(order.getMenu().getAmount() * order.getCount());
        });
        return totalPrice.get();
    }

    private String sendTo(Barista barista, List<Order> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    public String takeOrder(List<Order> receivedOrders, long totalPrice) {
        cafe.plusSales(totalPrice);
        return sendTo(new Barista(0,0), receivedOrders);
    }
}
