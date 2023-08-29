package com.wanted.preonboarding.cafe.service.handler;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CaffeOrders {
    private final List<CaffeOrder> caffeOrders;

    public Long calculateTotalPrice() {
        return caffeOrders.stream()
                .mapToLong(CaffeOrder::orderPrice)
                .sum();
    }

    public String details() {
        return caffeOrders.stream()
                .map(CaffeOrder::toString)
                .collect(Collectors.joining("\n"));
    }
}
