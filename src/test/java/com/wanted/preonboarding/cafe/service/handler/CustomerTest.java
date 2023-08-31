package com.wanted.preonboarding.cafe.service.handler;

import static org.assertj.core.api.Assertions.*;
import com.wanted.preonboarding.cafe.service.handler.domain.Menu;
import com.wanted.preonboarding.cafe.service.handler.domain.PaymentMethod;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerTest {

    @Autowired
    Cafe cafe;

    @Test
    @DisplayName("음료를 주문하고, 주문 내역을 받는다.")
    void buy_drinks() {
        // given
        Map<Menu, Integer> menus = new HashMap<>();
        menus.put(Menu.AMERICANO, 10);
        menus.put(Menu.LATTE, 2);
        menus.put(Menu.ADE, 2);

        Customer customer = new Customer(PaymentMethod.CARD, menus);


        // when
        Cafe cafe = new Cafe();
        Cashier cashier = new Cashier(cafe);
        CafeOrder cafeOrder = customer.buyCoffee(cashier);

        // then
        assertThat(cafeOrder).isNotNull();
        assertThat(cafeOrder.getTotalPrice()).isEqualTo(24000);
        assertThat(cafeOrder.getItems()).hasSize(3)
                .extracting("menu", "quantity", "isMade")
                .containsAnyOf(
                        tuple(Menu.AMERICANO, 10, true),
                        tuple(Menu.LATTE, 2, true),
                        tuple(Menu.ADE, 2, true)
                );
    }
}