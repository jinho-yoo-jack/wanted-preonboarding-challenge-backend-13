package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

import java.util.Set;

@Getter
public class Order {

    private final Payment payment;

    private final Set<OrderMenu> orderMenus;

    public Order(Payment payment, Set<OrderMenu> orderMenus) {
        this.payment = payment;
        this.orderMenus = orderMenus;
    }
}
