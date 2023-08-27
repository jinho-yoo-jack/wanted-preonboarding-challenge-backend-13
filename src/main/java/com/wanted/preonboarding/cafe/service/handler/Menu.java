package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;


public class Menu {
    private final Map<String, Integer> drinks;
    private final String paymentMethod;
    public Menu(String paymentMethod, Map<String, Integer> drinks) {
        this.paymentMethod = paymentMethod;
        this.drinks = drinks;
    }

    public Map<String, Integer> getDrinks() {
        return drinks;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
