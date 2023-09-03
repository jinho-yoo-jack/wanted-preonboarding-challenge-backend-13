package com.wanted.preonboarding.cafe.entity;

public enum Menu {
    AMERICANO(100L), LATTE(120L), ESPRESSO(90L);

    private long price;

    private Menu(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
