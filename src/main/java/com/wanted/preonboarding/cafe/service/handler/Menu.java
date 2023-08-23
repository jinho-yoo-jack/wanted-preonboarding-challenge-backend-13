package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

@Getter
public enum Menu {
    AMERICANO("Americano", 4000),
    ICED_AMERICANO("Iced americano", 4500),
    LATTE("Latte", 5000),
    ICED_LATTE("Iced latte", 5500)
    ;

    private final String name;
    private final Integer price;

    Menu(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
