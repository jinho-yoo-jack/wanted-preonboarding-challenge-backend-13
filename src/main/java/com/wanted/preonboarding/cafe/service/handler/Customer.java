package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private String paymentMethod;
    private final Map<String, Integer> myOrders;
}
