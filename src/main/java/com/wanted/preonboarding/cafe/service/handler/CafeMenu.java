package com.wanted.preonboarding.cafe.service.handler;

public enum CafeMenu {
    AMERICANO(100L), ICE_TEA(200L), BUBBLE_TEA(300L);

    private final Long price;

    CafeMenu(Long price) {
        this.price = price;
    }

    public Long getPrice() { return price; }
}