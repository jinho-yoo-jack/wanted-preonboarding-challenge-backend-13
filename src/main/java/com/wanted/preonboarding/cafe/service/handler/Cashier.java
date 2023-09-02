package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.domain.Order;
import com.wanted.preonboarding.cafe.domain.Rank;
import com.wanted.preonboarding.cafe.domain.Status;
import com.wanted.preonboarding.cafe.dto.OrderRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@AllArgsConstructor
public class Cashier {
    public long calculateTotalPrice(List<Order> orders) {
        AtomicLong totalPrice = new AtomicLong(0L);
        orders.forEach(order -> {
            totalPrice.addAndGet(order.getMenu().getAmount() * order.getCount());
        });
        return totalPrice.get();
    }

    public String sendTo(Barista barista, List<Order> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }
}
