package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
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
        Map<Drink, Integer> menus = new HashMap<>();
        menus.put(Drink.AMERICANO, 10);
        menus.put(Drink.LATTE, 2);
        menus.put(Drink.ADE, 2);

        Customer customer = new Customer(PaymentMethod.CARD, menus);

        // when


        // then
    }

}