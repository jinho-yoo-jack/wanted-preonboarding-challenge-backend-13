package com.wanted.preonboarding.cafe.service.handler;

import static org.assertj.core.api.Assertions.*;

import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
import com.wanted.preonboarding.cafe.service.handler.domain.PaymentMethod;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    @DisplayName("음료를 주문하고, 주문 내역을 받는다.")
    void buy_drinks() {
        // given
        Map<Drink, Integer> menus = new HashMap<>();
        menus.put(Drink.AMERICANO, 10);
        menus.put(Drink.LATTE, 2);
        menus.put(Drink.ADE, 2);

        Customer customer = new Customer(PaymentMethod.CARD, menus);

        // when
        Cafe cafe = new Cafe();
        Cashier cashier = new Cashier(cafe);
        CafeOrder cafeOrder = customer.buyCoffee(cashier);

        // then
        assertThat(cafeOrder).isNotNull();
        assertThat(cafeOrder.getTotalPrice()).isEqualTo(24000);
        assertThat(cafeOrder.getItems()).hasSize(3)
                .extracting("drink", "quantity", "isMade")
                .containsAnyOf(
                        tuple(Drink.AMERICANO, 10, true),
                        tuple(Drink.LATTE, 2, true),
                        tuple(Drink.ADE, 2, true)
                );
    }

}