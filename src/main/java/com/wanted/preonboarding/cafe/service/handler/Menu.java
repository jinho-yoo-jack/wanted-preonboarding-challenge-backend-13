package com.wanted.preonboarding.cafe.service.handler;

public class Menu {

    private final String name;
    private final Long price;

    public Menu(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public Long getPrice() {
        return this.price;
    }
}
