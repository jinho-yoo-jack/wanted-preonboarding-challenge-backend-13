package com.wanted.preonboarding.cafe.service.handler;

public enum Drink {
    AMERICANO(100L),
    LATTE(200L),
    ESPRESSO(100L)
    ;

    private final Long price;
    Drink(Long price) {
        this.price = price;
    }
    public Long getPrice() {
        for (Drink drink: Drink.values()) {
            if (this.equals(drink)) {
                return this.price;
            }
        }
        return null;
    }
}
