package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.enums.BaristaEnum;
import com.wanted.preonboarding.cafe.enums.MenuEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class Cashier {
    private final Cafe cafe;

    public String takeOrder(Map<String, Long> orders) {
        if (hasOverMenuCount(orders)) {
            long totalPrice = calculateTotalPrice(orders);
            cafe.plusSales(totalPrice);

            return sendTo(Barista.builder()
                    .rank(BaristaEnum.BEGINNER_WAIT.getRank())
                    .status(BaristaEnum.BEGINNER_WAIT.getStatus())
                    .build(), orders);
        } else {
            return null;
        }
    }

    private String sendTo(Barista barista, Map<String, Long> orders) {
        return barista.makeCoffeeTo(orders);
    }

    private long calculateTotalPrice(Map<String, Long> orders) {
        long totalPrice = 0L;

        for (String key : orders.keySet()) {
            if (key.equalsIgnoreCase(MenuEnum.AMERICANO.name())) {
                totalPrice += MenuEnum.AMERICANO.getPrice() * orders.get(key);
            } else if (key.equalsIgnoreCase(MenuEnum.JUICE.name())) {
                totalPrice += MenuEnum.JUICE.getPrice() * orders.get(key);
            } else {
                totalPrice += MenuEnum.TEA.getPrice() * orders.get(key);
            }
        }

        return totalPrice;
    }

    private boolean hasOverMenuCount(Map<String, Long> orders) {
        return orders.size() <= 3;
    }
}
