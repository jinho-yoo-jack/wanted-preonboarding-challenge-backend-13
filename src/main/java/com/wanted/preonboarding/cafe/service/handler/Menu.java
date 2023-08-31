package com.wanted.preonboarding.cafe.service.handler;

public enum Menu {
    AMERICANO(100L), LATTE(200L), CARAMEL_MACCHIATO(300L);

    private final long price;

    Menu(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
