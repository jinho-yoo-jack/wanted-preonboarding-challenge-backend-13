package com.wanted.preonboarding.cafe.service.handler;


import static org.assertj.core.api.Assertions.*;

import com.wanted.preonboarding.cafe.service.handler.domain.Menu;
import com.wanted.preonboarding.cafe.service.handler.domain.PaymentMethod;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CafeTest {

    @Test
    @DisplayName("고객의 주문을 받는다.")
    void received_order_of() {
        // given
        Map<Menu, Integer> menus = new HashMap<>();
        menus.put(Menu.AMERICANO, 3);
        menus.put(Menu.LATTE, 5);
        menus.put(Menu.ADE, 2);

        Customer customer = new Customer(PaymentMethod.CARD, menus);

        // when
        Cafe wantedCafe = new Cafe();
        CafeOrder cafeOrder = wantedCafe.receivedOrderOf(customer);

        // then
        assertThat(cafeOrder).isNotNull();
        assertThat(cafeOrder.getItems()).hasSize(3)
                .extracting("menu", "quantity", "isMade")
                .containsAnyOf(
                        tuple(Menu.AMERICANO, 3, true),
                        tuple(Menu.LATTE, 5, true),
                        tuple(Menu.ADE, 2, true)
                );
        assertThat(cafeOrder.getTotalPrice()).isEqualTo(23000);
    }
}