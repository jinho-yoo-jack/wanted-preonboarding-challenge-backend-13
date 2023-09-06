package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.entity.Coffee;
import com.wanted.preonboarding.cafe.entity.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomerTest {

    @Test
    @DisplayName("한종류의 커피를 구매한다.")
    void test() {
        // given
        List<Order> orders = List.of(new Order(Coffee.AMERICANO, 3L));
        Customer customer = new Customer("Card", orders);
        Cafe cafe = new Cafe();
        Cashier cashier = new Cashier(cafe);

        // when
        String message = customer.buyCoffee(cashier);

        // then
        Assertions.assertThat(message).isEqualTo("AMERICANO:3");
    }
}