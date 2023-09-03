package com.wanted.preonboarding.cafe.domain;

import com.wanted.preonboarding.cafe.domain.menu.CafeMenu;
import com.wanted.preonboarding.cafe.domain.menu.CafeMenuFactory;
import com.wanted.preonboarding.cafe.domain.menu.Menu;
import lombok.Getter;

public class OrderMenu {

    @Getter
    private final CafeMenu menu;

    @Getter
    private final int quantity;

    private OrderMenu(Menu menu, int quantity) {
        this(CafeMenuFactory.createCafeMenu(menu), quantity);
    }

    private OrderMenu(CafeMenu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public static OrderMenu from(String menuName, int quantity) {
        return new OrderMenu(Menu.of(menuName), quantity);
    }

    public static OrderMenu from(Menu menu, int quantity) {
        return new OrderMenu(menu, quantity);
    }

    public String menuName() {
        return menu.getName();
    }

    public long menuTotalPrice() {
        return menu.getPrice() * quantity;
    }
}
