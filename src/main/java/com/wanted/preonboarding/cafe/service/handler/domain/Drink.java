package com.wanted.preonboarding.cafe.service.handler.domain;

import lombok.Getter;

@Getter
public enum Drink {
    AMERICANO(1000),
    LATTE(2000),
    ADE(5000);

    private final long price;

    Drink(long price) {
        this.price = price;
    }

    public long calculateDrinkPrice(int quantity) {
        return this.price * quantity;
    }
}
