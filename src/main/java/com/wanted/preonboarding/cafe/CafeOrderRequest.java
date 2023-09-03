package com.wanted.preonboarding.cafe;

import java.util.Map;


public record CafeOrderRequest(
        String paymentMethod,
        Map<String, Integer> orders
) {
}
