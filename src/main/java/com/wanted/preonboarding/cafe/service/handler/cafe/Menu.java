package com.wanted.preonboarding.cafe.service.handler.cafe;

public enum Menu {

    AMERICANO(100L),LATTE(120L),ESPRESSO(80L);

    private final Long price;

    Menu(Long price) {
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }
}
