package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Order;
import com.wanted.preonboarding.cafe.service.handler.OrderItem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CafeServiceTest {

    Cafe cafe = new Cafe();
    CafeService cafeService = new CafeService(cafe);


    @Test
    @DisplayName("커피 주문 성공")
    void orderSuccess() throws Exception {
        // given
        Long previousSales = (Long) ReflectionTestUtils.getField(cafe, "sales");
        Order order = new Order(List.of(
                new OrderItem("AMERICANO", 3),
                new OrderItem("CAFE_LATTE", 1),
                new OrderItem("ESPRESSO", 2)
        ));

        // when
        String coffees = cafeService.orderFrom(order);

        // then
        assertThat(coffees).isEqualTo("AMERICANO:3CAFE_LATTE:1ESPRESSO:2");
        Long currentSales = (Long) ReflectionTestUtils.getField(cafe, "sales");
        assertThat(currentSales).isEqualTo(previousSales + order.calculateTotalPrice());
    }

    @Test
    @DisplayName("메뉴판에 없는 메뉴는 주문 할 수 없다.")
    void orderFailed() throws Exception {
        // expected
        assertThatThrownBy(() -> {
            Order order = new Order(List.of(
                    new OrderItem("COKE", 3)
            ));
        }).isInstanceOf(RuntimeException.class);
    }
}