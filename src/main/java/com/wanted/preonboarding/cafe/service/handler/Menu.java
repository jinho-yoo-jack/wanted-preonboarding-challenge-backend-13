package com.wanted.preonboarding.cafe.service.handler;

import java.util.Arrays;

public enum Menu {

    AMERICANO("AMERICANO",4000),
    CAFE_LATTE("CAFE_LATTE",5000),
    ESPRESSO("ESPRESSO",3000);

    private final String name;
    private final int price;

    Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static boolean exists(String name){
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.getName().equals(name));
    }
}
