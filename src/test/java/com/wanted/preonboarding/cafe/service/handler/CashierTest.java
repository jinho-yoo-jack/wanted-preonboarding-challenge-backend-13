package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.entity.Coffee;
import com.wanted.preonboarding.cafe.entity.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class CashierTest {
    @Test
    @DisplayName("주문을 바탕으로 총액을 계산한다. (커피 한종류)")
    void test() {
        // given
        List<Order> orders = List.of(new Order(Coffee.AMERICANO, 3L));
        Cafe cafe = new Cafe();
        Cashier cashier = new Cashier(cafe);

        // when
        long totalPrice = cashier.calculateTotalPrice(orders);

        // then
        Assertions.assertThat(totalPrice).isEqualTo(300L);
    }
}