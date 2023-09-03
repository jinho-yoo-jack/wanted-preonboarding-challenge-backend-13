package com.wanted.preonboarding.cafe.domain.menu;

import static com.wanted.preonboarding.cafe.domain.menu.Menu.AMERICANO;

public class CafeMenuFactory {
    public static CafeMenu createCafeMenu(Menu menu) {
        if (AMERICANO.equals(menu)) {
            return new Americano();
        } else if (Menu.ESPRESSO.equals(menu)) {
            return new Espresso();
        } else if (Menu.LATTE.equals(menu)) {
            return new Latte();
        }
        throw new IllegalArgumentException("존재 하지 않은 메뉴 입니다.");
    }
}
