package com.wanted.preonboarding.cafe;

import lombok.Getter;

@Getter
public enum MENU {
    ARMERICANO(4000),
    LATTE(5000),
    FRAPPUCCINO(6500);

    private int price;

    MENU(int price) {
        this.price = price;
    }
}
