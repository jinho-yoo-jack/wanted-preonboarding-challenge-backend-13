package com.wanted.preonboarding.cafe.domain.menu;

import com.wanted.preonboarding.cafe.domain.menu.CafeMenu;

public class Americano extends CafeMenu {
    public Americano() {
        super("Americano", 1000L);
    }

    @Override
    public void makeMenu() {
        System.out.println("아메리카노를 만들었습니다.");
    }
}
