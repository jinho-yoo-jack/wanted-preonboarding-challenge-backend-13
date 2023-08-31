package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
import java.util.List;
import java.util.Map;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public CafeOrder takeOrder(Map<Drink, Integer> receivedOrders) {
        long totalPrice = calculateDrinks(receivedOrders);
        cafe.plusSales(totalPrice);
        List<CafeOrderItem> items = sendTo(new Barista(), receivedOrders);
        return new CafeOrder(items, totalPrice);
    }

    public long calculateDrinks(Map<Drink, Integer> menus) {
        return menus.keySet().stream()
                .mapToLong(drink -> drink.calculateDrinkPrice(menus.get(drink)))
                .sum();
    }

    private List<CafeOrderItem> sendTo(Barista barista, Map<Drink, Integer> receivedOrders) {
        return barista.makeDrink(receivedOrders);
    }
}
