package com.wanted.preonboarding.cafe.service.handler;

import static org.assertj.core.api.Assertions.*;

import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
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
        Map<Drink, Integer> menus = new HashMap<>();
        menus.put(Drink.AMERICANO, 3);
        menus.put(Drink.LATTE, 5);
        menus.put(Drink.ADE, 2);

        Customer customer = new Customer(PaymentMethod.CARD, menus);

        // when
        Cafe wantedCafe = new Cafe();
        CafeOrder cafeOrder = wantedCafe.receivedOrderOf(customer);

        // then
        assertThat(cafeOrder).isNotNull();
        assertThat(cafeOrder.getItems()).hasSize(3)
                .extracting("drink", "quantity", "isMade")
                .containsAnyOf(
                        tuple(Drink.AMERICANO, 3, true),
                        tuple(Drink.LATTE, 5, true),
                        tuple(Drink.ADE, 2, true)
                );
        assertThat(cafeOrder.getTotalPrice()).isEqualTo(23000);
    }
}