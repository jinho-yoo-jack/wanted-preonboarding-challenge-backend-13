package com.wanted.preonboarding.cafe.service.handler;

import static org.assertj.core.api.Assertions.*;

import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CashierTest {

    @Autowired
    Cafe cafe;

    @Test
    @DisplayName("주문받은 음료의 총 금액을 계산한다.")
    void calculate_drinks_test() {
        // given
        Map<Drink, Integer> menus = new HashMap<>();
        menus.put(Drink.AMERICANO, 10);
        menus.put(Drink.LATTE, 3);
        menus.put(Drink.ADE, 2);

        Cashier cashier = new Cashier(cafe);

        // when
        long totalPrice = cashier.calculateDrinks(menus);

        // then
        assertThat(totalPrice).isEqualTo(26000);
    }

}