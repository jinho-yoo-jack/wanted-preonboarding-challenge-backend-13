package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Barista {
    private int rank; // 0: Beginner 1: Middle 2: Master
    private int status; // 0: Waiting 1: Making

    public Barista() {
        this.rank = 0;
        this.status = 0;
    }

    public String makeCoffeeTo(Cafe cafe, Map<String, Integer> orders) {
        List<Beverage> beverageList = cafe.getMenu().getBeverageList();
        List<String> menuNames = beverageList.stream().map(Beverage::getName).toList();
        StringBuilder makeOrders = new StringBuilder();
        for (String coffeeName : orders.keySet()) {
            if (menuNames.contains(coffeeName)) {
                int quantity = orders.get(coffeeName);
                makeOrders.append(coffeeName)
                        .append(":")
                        .append(quantity);
            }
        }
        return makeOrders.toString();
    }
}
