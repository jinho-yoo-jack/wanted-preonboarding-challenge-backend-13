package com.wanted.preonboarding.cafe.domain.menu;

public class Latte extends CafeMenu {
    public Latte() {
        super("Latte", 1200L);
    }

    @Override
    public void makeMenu() {
        System.out.println("라떼 만들었습니다.");
    }
}
