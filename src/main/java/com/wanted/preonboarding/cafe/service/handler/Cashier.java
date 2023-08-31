package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(Order order) {
        long totalPrice = 0L;

        for (String drinkName : order.getMenu().keySet()) {
            Long price = Menu.valueOf(drinkName).getPrice();
            totalPrice += price * order.getMenu().get(drinkName);
        }

        return totalPrice;
    }

    private String sendTo(Barista barista, Order receivedOrder) {
        return barista.makeCoffeeTo(receivedOrder.getMenu());
    }

    public String takeOrder(Order receivedOrder, long totalPrice) {
        cafe.plusSales(totalPrice);
        return sendTo(new Barista(0, 0), receivedOrder);
    }
}
