package com.wanted.preonboarding.cafe.service.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CashierTest {
    @DisplayName("주문한 커피의 총 가격을 계산한다.")
    @Test
    void calculateTotalPrice() {
        // given
        Cashier cashier = new Cashier();
        Map<String, Integer> order = new HashMap<>();
        Map<String, Long> prices = new HashMap<>();
        order.put("AMERICANO", 3);
        prices.put("AMERICANO", 100L);

        // when
        long totalPrice = cashier.calculateTotalPrice(order, prices);

        // then
        assertThat(totalPrice).isEqualTo(300L);
    }
}