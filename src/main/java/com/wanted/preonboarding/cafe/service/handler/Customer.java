package com.wanted.preonboarding.cafe.service.handler;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {
    private String paymentMethod;
    private Map<String, Integer> myOrders;
}
