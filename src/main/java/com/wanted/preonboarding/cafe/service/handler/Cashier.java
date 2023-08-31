package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Cashier {

    public Cashier() {
    }

    public long calculateTotalPrice(Cafe cafe, Map<String, Integer> orders) {
        int totalPrice = 0;
        List<Beverage> beverageList = cafe.getMenu().getBeverageList();
        for (String key : orders.keySet()) {
            for (Beverage beverage : beverageList) {
                if (key.equals(beverage.getName())) {
                    totalPrice += beverage.getFee() * orders.get(key);
                }
            }
        }
        return totalPrice;
    }

    private String sendTo(Cafe cafe, Map<String, Integer> receivedOrders) {
        return cafe.getBarista().makeCoffeeTo(cafe, receivedOrders);
    }

    public String takeOrder(Cafe cafe, Map<String, Integer> receivedOrders, long totalPrice) {
        cafe.plusSales(totalPrice);
        return sendTo(cafe, receivedOrders);
    }
}
