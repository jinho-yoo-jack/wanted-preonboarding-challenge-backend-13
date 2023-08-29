package com.wanted.preonboarding.cafe.service.handler;

import java.awt.*;

public record CaffeOrder(Menu menu, int quantity) {
    public long orderPrice() {
        return menu.getPrice() * quantity;
    }

    public String toString() {
        return menu + ":" + quantity;
    }
}
