package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.entity.BeverageType;
import com.wanted.preonboarding.cafe.entity.Order;
import com.wanted.preonboarding.cafe.entity.OrderComponent;
import com.wanted.preonboarding.cafe.entity.OrderItem;
import com.wanted.preonboarding.cafe.exception.MenuOrderException;

import java.util.Map;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(Order orders) throws MenuOrderException {
        long totalPrice = 0L;
        for (OrderComponent key : orders.getKeySet()) {
            BeverageType beverage = BeverageType.getBeverageTypeByInputName(key.getName());
            totalPrice += beverage.getPrice() * key.getAmount();
        }
        return totalPrice;
    }

    private String sendTo(Barista barista, Order receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    public String takeOrder(Order receivedOrders, long totalPrice) {
        cafe.plusSales(totalPrice);
        return sendTo(new Barista(0,0), receivedOrders);
    }
}
