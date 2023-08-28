package com.wanted.preonboarding.cafe.service.handler;

import java.util.List;
import java.util.Map;

import com.wanted.preonboarding.cafe.service.Dtos.RequestOrders;
import com.wanted.preonboarding.cafe.service.enums.DrinkEnum;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(Map<String, Integer> orders) {
        long totalPrice = 0L;

        for (String key : orders.keySet()) {
            String drinkName = key.toUpperCase();
            totalPrice += DrinkEnum.getPriceByName(drinkName) * orders.get(key);
        }
        return totalPrice;
    }

    public String takeOrder(Map<String, Integer> receivedOrders, long totalPrice) {
        cafe.plusSales(totalPrice);
        Barista barista1 = new Barista(0, 0);
        return barista1.makeCoffeeTo(receivedOrders);

    }
}
