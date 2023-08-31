package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.dto.request.Order;
import java.util.List;
import java.util.Map;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(Map<String, Integer> orders) {
        long totalPrice = 0L;
        long americanoPrice = 100L;
        for (String key : orders.keySet()) {
            if (key.equalsIgnoreCase("AMERICANO"))
                totalPrice += americanoPrice * orders.get(key);
        }
        return totalPrice;
    }

    public Long calculateTotalPrice(List<Order> orderList, Map<String, Long> menu) {
        Long totalPrice = 0L;
        for(Order order : orderList) {
            totalPrice += menu.get(order.getName()) * order.getQuantity();
        }
        return totalPrice;
    }

    private String sendTo(Barista barista, Map<String, Integer> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    public String takeOrder(Map<String, Integer> receivedOrders, long totalPrice) {
        cafe.plusSales(totalPrice);
        return sendTo(new Barista(0,0), receivedOrders);
    }
}
