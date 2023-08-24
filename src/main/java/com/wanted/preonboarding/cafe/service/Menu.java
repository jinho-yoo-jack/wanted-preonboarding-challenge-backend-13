package com.wanted.preonboarding.cafe.service;

import lombok.Getter;

@Getter
public enum Menu {
    AMERICANO(100), LATTE(200), TEA(300);
    private final int price;

    private Menu(int price) {
        this.price = price;
    }
}
