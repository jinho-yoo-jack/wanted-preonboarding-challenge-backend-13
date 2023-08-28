package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.entity.Order;
import com.wanted.preonboarding.cafe.entity.Orders;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(Orders orders) {
        long totalPrice = 0L;

        for (Order order : orders.getOrderList()) {
            totalPrice += order.getTotalPrice();
        }

        return totalPrice;
    }

    private String sendTo(Barista barista, Orders receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    public String takeOrder(Orders receivedOrders, long totalPrice) {
        cafe.plusSales(totalPrice);
        return sendTo(new Barista(0, 0), receivedOrders);
    }
}
