package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Order {
    private PaymentMethod paymentMethod;
    private Long totalPrice;
}
