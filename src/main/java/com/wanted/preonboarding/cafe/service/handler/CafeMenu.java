package com.wanted.preonboarding.cafe.service.handler;

public enum CafeMenu {
    AMERICANO(100L),
    LATTE(150L),
    JUICE(200L);

    private final long price;

    CafeMenu(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public static CafeMenu getCafeMenu(String menuName) {
        for (CafeMenu menu : CafeMenu.values()) {
            if (menuName.equalsIgnoreCase(menu.name())) {
                return menu;
            }
        }
        throw new IllegalArgumentException(menuName+ "은 존재하지 않는 메뉴입니다.");
    }
}
