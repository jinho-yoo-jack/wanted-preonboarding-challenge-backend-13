package com.wanted.preonboarding.cafe.service.handler;

import lombok.extern.slf4j.Slf4j;

import java.util.EnumMap;
import java.util.Map;

@Slf4j
public class Orders {

    public static final String EMPTY_SPACE = " ";
    public static final String DELIMITER = ":";
    private Map<CafeMenu, Integer> orders = new EnumMap<>(CafeMenu.class);

    public Orders(Map<String, Integer> requestOrders) {
        for (Map.Entry<String, Integer> entry : requestOrders.entrySet()) {
            this.orders.put(CafeMenu.getCafeMenu(entry.getKey()), entry.getValue());
        }
    }

    public Long getTotalPrice() {
        long totalPrice = 0L;
        for (Map.Entry<CafeMenu, Integer> entry : orders.entrySet()) {
            long price = entry.getKey().getPrice();
            int quantity = entry.getValue();
            totalPrice += price * quantity;
        }
        log.info("totalPrice: {}", totalPrice);
        return totalPrice;
    }

    public String printAll() {
        StringBuilder makeOrders = new StringBuilder();
        for (Map.Entry<CafeMenu, Integer> entry : orders.entrySet()) {
            makeOrders.append(entry.getKey().name())
                    .append(DELIMITER)
                    .append(entry.getValue())
                    .append(EMPTY_SPACE);
        }

        return makeOrders.toString();
    }
}
