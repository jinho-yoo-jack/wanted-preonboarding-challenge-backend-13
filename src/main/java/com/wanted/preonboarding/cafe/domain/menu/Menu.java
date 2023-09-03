package com.wanted.preonboarding.cafe.domain.menu;

import java.util.Arrays;

public enum Menu {
    AMERICANO("Americano"),
    LATTE("Latte"),
    ESPRESSO("Espresso");
    private final String name;

    Menu(String name) {
        this.name = name;
    }

    public static Menu of(String menuName) {
        return Arrays.stream(values())
                .filter(menu -> menu.name.equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 메뉴 입니다."));
    }

    public String getName() {
        return name;
    }
}
