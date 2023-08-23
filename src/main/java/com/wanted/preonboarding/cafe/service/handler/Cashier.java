package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.exception.CafeErrorCode;
import com.wanted.preonboarding.cafe.exception.CafeException;

import java.util.*;

public class Cashier {

    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(Orders orders) {
        long totalPrice = 0L;
        Map<Menu, Integer> orderItems = orders.getOrderItems();
        for (Map.Entry<Menu, Integer> entry : orderItems.entrySet()) {
            Menu menu = entry.getKey();
            Integer quantity = entry.getValue();
            totalPrice += (long) menu.getPrice() * quantity;
        }
        return totalPrice;
    }

    private String sendTo(Barista barista, Orders orders) {
        return barista.makeCoffeeTo(orders);
    }

    public String takeOrder(Orders orders, long totalPrice) {
        cafe.plusSales(totalPrice);
        List<Barista> baristaList = cafe.getBaristaList();
        Barista barista = baristaList.stream().filter(b -> b.getStatus() == 0).findAny().orElseThrow(() -> new CafeException(CafeErrorCode.ALL_BARISTAS_IN_WORK));
        return sendTo(barista, orders);
    }
}
