package com.wanted.preonboarding.cafe.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Cashier {
    /**
     * 주문에 대한 총액 계산을 합니다.
     */
    public long calculateTotalPrice(List<Order> orders) {
        AtomicLong totalPrice = new AtomicLong(0L);
        orders.forEach(order -> {
            totalPrice.addAndGet(order.getMenu().getAmount() * order.getCount());
        });
        return totalPrice.get();
    }

    /**
     * 캐셔는 바리스타의 상황을 판단하여 메뉴 제조를 요청합니다.
     */
    public String sendTo(Barista barista, List<Order> receivedOrders) {
        if (!barista.isBusy()) {
            return barista.makeCoffeeTo(receivedOrders);
        }

        throw new IllegalStateException("barista is busy...");
    }
}
