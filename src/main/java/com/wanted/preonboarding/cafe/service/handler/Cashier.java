package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.common.biginteger.Calculator;

import java.math.BigInteger;
import java.util.List;

import static com.wanted.preonboarding.common.biginteger.Calculator.*;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public BigInteger calculateTotalPrice(List<Order> orders) {
        return orders.stream()
                .map(order -> multiply(order.getMenu().getPrice(), BigInteger.valueOf(order.getQuantity())))
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    private String sendTo(Barista barista, List<Order> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    public String takeOrder(List<Order> receivedOrders, BigInteger totalPrice) {
        cafe.plusSales(totalPrice);
        return sendTo(new Barista(0,0), receivedOrders);
    }
}
