package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.Menu;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public String takeOrder(Order order) {
        long totalPrice = order.getTotalPrice();
        cafe.plusSales(totalPrice);
        return sendTo(new Barista(0, 0), order.getOrder());
    }


    private String sendTo(Barista barista, Map<Menu, Integer> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }
}
