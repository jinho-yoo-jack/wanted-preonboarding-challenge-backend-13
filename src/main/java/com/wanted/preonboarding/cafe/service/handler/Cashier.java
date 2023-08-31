package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Cashier {

    // 주문한 음료의 총 가격을 계산한다.
    public long calculateTotalPrice(Map<String, Integer> orders, Map<String, Long> prices) {
        return prices.entrySet()
            .stream()
            .filter(entry -> orders.containsKey(entry.getKey()))
            .mapToLong(entry -> entry.getValue() * orders.get(entry.getKey()))
            .sum();
    }
}
