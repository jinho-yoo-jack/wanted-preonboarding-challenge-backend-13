package com.wanted.preonboarding.cafe.service.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class Cashier {
    private final Cafe cafe;

    @Autowired
    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public String takeOrder(Map<String, Integer> receivedOrders) {
        long totalPrice = calculateTotalPrice(receivedOrders);
        cafe.plusSales(totalPrice);
        return sendTo(new Barista(0,0), receivedOrders);
    }

    private String sendTo(Barista barista, Map<String, Integer> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    private long calculateTotalPrice(Map<String, Integer> orders) {
        long totalPrice = 0L;

        for (String drink : orders.keySet()) {
            Menu selectedMenu = Menu.valueOf(drink);
            long price = selectedMenu.getPrice();
            int count = orders.get(drink);
            totalPrice += (price * count);
        }
        log.info("order totalPrice = {}", totalPrice);
        return totalPrice;
    }
}
