package com.wanted.preonboarding.cafe.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Cashier {
    public long calculateTotalPrice(List<OrderMenu> orders) {
        AtomicLong totalPrice = new AtomicLong(0L);

        orders.forEach(order -> {
            totalPrice.addAndGet(order.menuTotalPrice());
        });

        return totalPrice.get();
    }
}
