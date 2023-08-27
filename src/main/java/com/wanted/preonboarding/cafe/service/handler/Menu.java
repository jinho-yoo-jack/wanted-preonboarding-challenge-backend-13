package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.theater.service.handler.Ticket;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
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
