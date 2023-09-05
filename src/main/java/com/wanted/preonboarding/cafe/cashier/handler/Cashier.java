package com.wanted.preonboarding.cafe.cashier.handler;

import com.wanted.preonboarding.cafe.barista.handler.Barista;
import com.wanted.preonboarding.cafe.cafe.service.dto.OrderItem;
import com.wanted.preonboarding.cafe.cafe.service.handler.Cafe;

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

    public void purchase(List<OrderItem> beverages) {
        long purchaseAmount = calculateTotalPrice(beverages);
        Barista barista = new Barista(0, 0);
        barista.makeBeverageTo(beverages);
        cafe.plusSales(purchaseAmount);
    }

    private long calculateTotalPrice(List<OrderItem> beverages) {
        return beverages.stream()
                .map(this::getTotalPriceFromOrderItem)
                .mapToLong(Long::longValue)
                .sum();
    }

    private long getTotalPriceFromOrderItem(OrderItem beverage) {
        long cost = beverage.getBeverage().getCost();
        long count = beverage.getCount();
        return cost * count;
    }

    private String sendTo(Barista barista, Map<String, Integer> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    public String takeOrder(Map<String, Integer> receivedOrders, long totalPrice) {
        cafe.plusSales(totalPrice);
        return sendTo(new Barista(0, 0), receivedOrders);
    }
}
