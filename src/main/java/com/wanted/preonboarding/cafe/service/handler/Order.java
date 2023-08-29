package com.wanted.preonboarding.cafe.service.handler;

public record Order(Menu menu, int quantity) {
    public long orderPrice() {
        return menu().getPrice() * quantity;
    }
}
