package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Cashier {

    public long calculateTotalPrice(Map<Beverage, Integer> orders) {
        return orders.entrySet().stream()
            .map(entry -> {
                long price = entry.getKey().getPrice();
                int quantity = entry.getValue();
                return price * quantity;
            })
            .mapToLong(i -> i).sum();
    }

}
