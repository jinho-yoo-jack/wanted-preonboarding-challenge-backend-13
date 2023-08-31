package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private Map<String, Integer> menu;
    private String paymentMethod;

    public Order(Map<String, Integer> menu, String paymentMethod) {
        this.menu = menu;
        this.paymentMethod = paymentMethod;
    }

    public Map<String, Integer> getMenu() {
        return menu;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
