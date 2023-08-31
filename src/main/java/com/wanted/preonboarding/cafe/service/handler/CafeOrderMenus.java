package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CafeOrderMenus {
    private static final int QUANTITY_ZERO = 0;
    private final Map<Drink, Integer> menus;

    public long calculateTotalPrice() {
        return menus.keySet().stream()
                .mapToLong(drink -> drink.calculateDrinkPrice(menus.get(drink)))
                .sum();
    }

    public Integer getQuantityOf(Drink drink) {
        return menus.getOrDefault(drink, QUANTITY_ZERO);
    }
}
