package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CafeOrderItem {
    private Drink drink;
    private int quantity;
    private boolean isMade;

    public static CafeOrderItem makeSuccess(Drink drink, int quantity) {
        return new CafeOrderItem(drink, quantity, true);
    }
}
