package com.wanted.preonboarding.cafe.service.handler;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerTest {

    @Test
    public void 고객은_커피를_주문할_수_있다() {
        // given
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Menu.AMERICANO, 1));
        orders.add(new Order(Menu.ICE_CHOCO, 1));

        Customer customer = new Customer(PaymentMethod.CARD, orders);

        Cafe cafe = new Cafe();

        Cashier cashier = new Cashier(cafe);

        // when
        String buyCoffee = customer.buyCoffee(cashier);

        // then
        assertThat(buyCoffee).isEqualTo("AMERICANO:1 ICE_CHOCO:1 ");
        assertThat(cashier.calculateTotalPrice(orders)).isEqualTo(8600L);
        assertThat(cafe.getSales()).isEqualTo(18600L);
    }

}