package com.wanted.preonboarding.cafe.service.handler;

import static org.assertj.core.api.Assertions.*;

import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CashierTest {

    @Test
    @DisplayName("고객으로 부터 주문을 받는다.")
    void take_order() {
        // given
        Map<Drink, Integer> menus = new HashMap<>();
        menus.put(Drink.AMERICANO, 10);
        menus.put(Drink.LATTE, 3);
        menus.put(Drink.ADE, 2);

        Cafe cafe = new Cafe();
        Cashier cashier = new Cashier(cafe);
        assertThat(cafe.getSales()).isEqualTo(10000);

        // when
        CafeOrderMenus cafeOrderMenus = new CafeOrderMenus(menus);
        CafeOrder cafeOrder = cashier.takeOrder(cafeOrderMenus);

        // then
        assertThat(cafeOrder).isNotNull();
        assertThat(cafeOrder.getTotalPrice()).isEqualTo(26000);
        assertThat(cafeOrder.getItems()).hasSize(3)
                .extracting("drink", "quantity", "isMade")
                .containsAnyOf(
                        tuple(Drink.AMERICANO, 10, true),
                        tuple(Drink.LATTE, 3, true),
                        tuple(Drink.ADE, 2, true)
                );

        assertThat(cafe.getSales()).isEqualTo(36000);
    }
}