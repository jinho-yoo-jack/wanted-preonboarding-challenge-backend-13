package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

@Getter
public enum Menu {
    AMERICANO(100L), TEA(150L), LATTE(200L);
    private final long price;

    Menu(long price) {
        this.price = price;
    }

    public long calculatePrice(int quantity) {
        return this.price * quantity;
    }
}
