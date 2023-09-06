package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.entity.Coffee;
import com.wanted.preonboarding.cafe.entity.Order;
import com.wanted.preonboarding.cafe.entity.PaymentMethod;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomerTest {

    @Test
    @DisplayName("한종류의 커피를 구매한다.")
    void orderCoffee() {
        // given
        List<Order> orders = List.of(new Order(Coffee.AMERICANO, 3L));
        Customer customer = new Customer(PaymentMethod.CARD, orders);
        Cafe cafe = new Cafe();
        Cashier cashier = new Cashier(cafe);

        // when
        String message = customer.buyCoffee(cashier);

        // then
        Assertions.assertThat(message).isEqualTo("AMERICANO:3 ");
    }

    @Test
    @DisplayName("세 종류의 커피를 구매한다.")
    void orderCoffees() {
        // given
        List<Order> orders = List.of(new Order(Coffee.AMERICANO, 3L), new Order(Coffee.LATTE, 2L), new Order(Coffee.ADE, 1L));
        Customer customer = new Customer(PaymentMethod.CARD, orders);
        Cafe cafe = new Cafe();
        Cashier cashier = new Cashier(cafe);

        // when
        String message = customer.buyCoffee(cashier);

        // then
        Assertions.assertThat(message).isEqualTo("AMERICANO:3 LATTE:2 ADE:1 ");
    }
}