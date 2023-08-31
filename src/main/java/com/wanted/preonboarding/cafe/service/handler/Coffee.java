package com.wanted.preonboarding.cafe.service.handler;

public class Coffee {
    private String name;
    private int price;

    private Coffee(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.price = menuItem.cost();
    }

    public static Coffee create(MenuItem menuItem) {
        return new Coffee(menuItem);
    }
}
