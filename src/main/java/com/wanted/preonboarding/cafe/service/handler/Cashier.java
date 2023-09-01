package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.domain.Order;
import com.wanted.preonboarding.cafe.domain.Rank;
import com.wanted.preonboarding.cafe.domain.Status;
import com.wanted.preonboarding.cafe.dto.OrderRequest;

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

    public String takeOrder(OrderRequest orderRequest) {
        cafe.plusSales(calculateTotalPrice(orderRequest.getOrder()));

        return sendTo(new Barista(Rank.BEGINNER, Status.WAITING), orderRequest.getOrder());
    }
}
