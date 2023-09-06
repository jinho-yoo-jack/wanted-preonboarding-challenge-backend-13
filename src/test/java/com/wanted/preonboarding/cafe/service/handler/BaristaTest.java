package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.entity.Coffee;
import com.wanted.preonboarding.cafe.entity.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BaristaTest {
    @Test
    @DisplayName("주문에 맞게 하나의 커피를 제조한다. ")
    void test() {
        // given
        List<Order> orders = List.of(new Order(Coffee.AMERICANO, 3L));
        Barista barista = new Barista(0, 0);

        // when
        String makeOrders = barista.makeCoffeeTo(orders);

        // then
        Assertions.assertThat(makeOrders).isEqualTo("AMERICANO:3 ");
    }
}