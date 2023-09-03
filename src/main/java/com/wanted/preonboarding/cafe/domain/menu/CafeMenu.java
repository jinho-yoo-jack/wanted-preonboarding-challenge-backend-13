package com.wanted.preonboarding.cafe.domain.menu;

import lombok.Getter;

@Getter
public abstract class CafeMenu {
    protected final String name;
    protected final long price;

    protected CafeMenu(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public abstract void makeMenu();
}
