package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.stream.IntStream;

public class Order {
    @Setter
    private String[] beverages;
    @Setter
    private Integer[] cups;

    public HashMap<String, Integer> getOrder() {
        HashMap<String, Integer> order = new HashMap<>();
        IntStream.range(0, Math.min(beverages.length, cups.length))
                .forEach(i -> order.put(beverages[i], cups[i]));
        return order;
    }
}