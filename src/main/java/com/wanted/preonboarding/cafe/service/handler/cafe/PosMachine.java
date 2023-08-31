package com.wanted.preonboarding.cafe.service.handler.cafe;

import com.wanted.preonboarding.cafe.service.handler.customer.Order;
import com.wanted.preonboarding.cafe.service.handler.customer.PaymentMethodType;

import java.util.List;

public class PosMachine {

    private final Cafe cafe;

    public PosMachine(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(List<Order> receivedOrders) {
        long totalPrice = 0L;

        for (Order order : receivedOrders) {
            totalPrice += order.getSelectedMenu().getPrice() * order.getQuantity();
        }

        return totalPrice;
    }

    public void pay(long totalPrice, PaymentMethodType paymentMethod) {
        cafe.plusSales(totalPrice);
    }
}
