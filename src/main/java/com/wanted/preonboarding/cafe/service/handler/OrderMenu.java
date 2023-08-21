package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

@Getter
public class OrderMenu {

    private final String name;
    private final Long quantity;

    public OrderMenu(String name, Long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public boolean is(OrderMenu orderMenu) {
        return orderMenu != null && orderMenu.getName().equals(name);
    }

    public boolean is(String name) {
        return name != null && name.equals(this.name);
    }
}
