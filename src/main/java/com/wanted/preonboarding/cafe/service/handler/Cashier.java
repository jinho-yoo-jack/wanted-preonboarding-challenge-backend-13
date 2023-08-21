package com.wanted.preonboarding.cafe.service.handler;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Cashier {

    private final List<Menu> menuList;

    public Cashier(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Cashier(Menu... menus) {
        this(Arrays.asList(menus));
    }

    public Long calculateTotalPrice(Set<OrderMenu> orderMenus) {
        Long price = 0L;
        for (OrderMenu orderMenu : orderMenus) {
            Menu orderedMenu = this.menuList.stream()
                    .filter(menu -> orderMenu.getName().equals(menu.getName()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException(orderMenu.getName() + " 에 해당하는 메뉴가 존재하지 않습니다."));
            price += orderedMenu.getPrice() * orderMenu.getQuantity();
        }
        return price;
    }
}
