package com.wanted.preonboarding.cafe.service.handler;

import java.util.List;

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
}
