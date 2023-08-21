package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

public class Customer {

    @Getter
    private final Order order;

    public Customer(Order order) {
        this.order = order;
    }

    public boolean hasOrderMenu() {
        return this.order != null && !this.order.getOrderMenus().isEmpty();
    }
}
