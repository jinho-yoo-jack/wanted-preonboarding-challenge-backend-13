package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

import com.wanted.preonboarding.cafe.service.handler.domain.Menu;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CafeOrderMenus {
    private static final int QUANTITY_ZERO = 0;
    private final Map<Menu, Integer> menus;

    public long calculateTotalPrice() {
        return menus.keySet().stream()
                .mapToLong(drink -> drink.calculateDrinkPrice(menus.get(drink)))
                .sum();
    }

    public Integer getQuantityOf(Menu menu) {
        return menus.getOrDefault(menu, QUANTITY_ZERO);
    }
}