package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.handler.domain.Menu;

import java.util.List;
import java.util.Map;

public class Cashier {
    private final Cafe cafe;
    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public CafeOrder takeOrder(CafeOrderMenus menus) {
        long totalPrice = calculateTotalPriceOf(menus);
        cafe.plusSales(totalPrice);
        List<CafeOrderItem> items = requestMakeDrinkTo(new Barista(), menus);
        return new CafeOrder(items, totalPrice);
    }

    private long calculateTotalPriceOf(CafeOrderMenus menus) {
        return menus.calculateTotalPrice();
    }

    private List<CafeOrderItem> requestMakeDrinkTo(Barista barista, CafeOrderMenus cafeOrderMenus) {
        return barista.makeDrink(cafeOrderMenus);
    }

    public long calculateDrinks(Map<Menu, Integer> menus) {
        return menus.keySet().stream()
                .mapToLong(drink -> drink.calculateDrinkPrice(menus.get(drink)))
                .sum();
    }
}
