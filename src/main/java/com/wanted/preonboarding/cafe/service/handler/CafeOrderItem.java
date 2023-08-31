package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.handler.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CafeOrderItem {
    private Menu menu;
    private int quantity;
    private boolean isMade;


    public static CafeOrderItem makeSuccess(Menu menu, int quantity) {
        return new CafeOrderItem(menu, quantity, true);
    }
}
