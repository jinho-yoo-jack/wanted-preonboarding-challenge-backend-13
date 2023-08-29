package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Cashier {
    private final Cafe cafe;
    private long totalPrice = 0L;
    private final long americanoPrice = 1900L;
    private final long lattePrice = 2900L;
    private final long iceTeaPrice = 4000L;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(Map<String, Integer> orders) {
        for (String key : orders.keySet()) {
            if (key.equalsIgnoreCase("AMERICANO")) {
                this.totalPrice += americanoPrice * orders.get(key);
            }
            else if (key.equalsIgnoreCase("LATTE")){
                this.totalPrice += lattePrice * orders.get(key);
            }
            else{
                this.totalPrice += iceTeaPrice * orders.get(key);
            }
        }
        return totalPrice;
    }

    public void takeOrder(long totalPrice) {
        cafe.plusSales(totalPrice);
    }
}
