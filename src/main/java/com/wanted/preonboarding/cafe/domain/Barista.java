package com.wanted.preonboarding.cafe.domain;

import com.wanted.preonboarding.cafe.domain.menu.CafeMenu;

import java.util.List;

public class Barista {
    private final BaristaRank rank;
    private final BaritaStauts status;

    public Barista(BaristaRank rank, BaritaStauts status) {
        this.rank = rank;
        this.status = status;
    }

    public String makeCoffeeTo(List<OrderMenu> orders) {
        StringBuilder makeOrders = new StringBuilder();
        for (OrderMenu orderMenu : orders) {

            makeCafeMenu(orderMenu.getMenu());

            makeOrders.append(orderMenu.menuName())
                    .append(":")
                    .append(orderMenu.getQuantity());
        }
        return makeOrders.toString();
    }

    public void makeCafeMenu(CafeMenu menu) {
        menu.makeMenu();
    }
}
