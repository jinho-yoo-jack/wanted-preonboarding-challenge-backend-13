package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Kitchen {
    private BaristaBehavior barista;

    public String makeBeverage(Map<String, Integer> receivedOrders){
        return barista.makeCoffeeTo(receivedOrders);
    }
}
