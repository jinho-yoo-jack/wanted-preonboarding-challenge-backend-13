package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class DefaultMenuCalculable implements MenuCalculable{
    @Override
    public long calculate(Map<MenuItem, Integer> orders) {
        long totalPrice = 0;
        for (MenuItem menuItem : orders.keySet()) {
                totalPrice += (long) menuItem.cost() * orders.get(menuItem);
        }
        return totalPrice;
    }
}
