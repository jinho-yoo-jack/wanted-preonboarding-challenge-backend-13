package com.wanted.preonboarding.cafe.domain.menu;

public class Espresso extends CafeMenu {
    public Espresso() {
        super("Espresso", 1500L);
    }

    @Override
    public void makeMenu() {
        System.out.println("에스프레소를 만들었습니다.");
    }
}
