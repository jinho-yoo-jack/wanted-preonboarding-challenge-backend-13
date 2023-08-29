package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

@Getter
public enum Menu {
    AMERICANO(3500L), LEMONADE(4000L), MILK(2000L);

    private final long price;

    Menu(long price) {
        this.price = price;
    }
}
