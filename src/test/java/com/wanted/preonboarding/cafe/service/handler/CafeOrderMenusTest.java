package com.wanted.preonboarding.cafe.service.handler;

import static org.assertj.core.api.Assertions.*;

import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CafeOrderMenusTest {

    @Test
    @DisplayName("주문받은 음료의 총 금액을 계산한다.")
    void calculate_drinks() {
        // given
        Map<Drink, Integer> menus = new HashMap<>();
        menus.put(Drink.AMERICANO, 2);
        menus.put(Drink.LATTE, 5);
        menus.put(Drink.ADE, 2);

        // when
        CafeOrderMenus cafeOrderMenus = new CafeOrderMenus(menus);
        long totalPrice = cafeOrderMenus.calculateTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(22000);
    }

    @Test
    @DisplayName("주문 내 특정 음료의 수량을 확인한다.")
    void get_quantity_of() {
        // given
        Map<Drink, Integer> menus = new HashMap<>();
        menus.put(Drink.AMERICANO, 3);
        menus.put(Drink.LATTE, 5);

        CafeOrderMenus cafeOrderMenus = new CafeOrderMenus(menus);

        // when
        Integer americano = cafeOrderMenus.getQuantityOf(Drink.AMERICANO);
        Integer latte = cafeOrderMenus.getQuantityOf(Drink.LATTE);

        // then
        assertThat(americano).isEqualTo(3);
        assertThat(latte).isEqualTo(5);
    }

    @Test
    @DisplayName("주문되지 않은 음료 수량 조회 시, 0으로 조회한다.")
    void no_order_drink_quantity_is_zero() {
        // given
        Map<Drink, Integer> menus = new HashMap<>();
        menus.put(Drink.AMERICANO, 3);

        CafeOrderMenus cafeOrderMenus = new CafeOrderMenus(menus);

        // when
        Integer latte = cafeOrderMenus.getQuantityOf(Drink.LATTE);

        // then
        assertThat(latte).isEqualTo(0);
    }
}