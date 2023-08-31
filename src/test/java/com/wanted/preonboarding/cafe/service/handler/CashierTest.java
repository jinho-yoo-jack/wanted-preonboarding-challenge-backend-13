package com.wanted.preonboarding.cafe.service.handler;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import com.wanted.preonboarding.cafe.service.handler.domain.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CashierTest {

    @Autowired
    Cafe cafe;

    @Test
    @DisplayName("고객으로 부터 주문을 받는다.")
    void take_order() {
        // given
        Map<Menu, Integer> menus = new HashMap<>();
        menus.put(Menu.AMERICANO, 10);
        menus.put(Menu.LATTE, 3);
        menus.put(Menu.ADE, 2);

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
                .extracting("menu", "quantity", "isMade")
                .containsAnyOf(
                        tuple(Menu.AMERICANO, 10, true),
                        tuple(Menu.LATTE, 3, true),
                        tuple(Menu.ADE, 2, true)
                );

        assertThat(cafe.getSales()).isEqualTo(36000);
    }
}
