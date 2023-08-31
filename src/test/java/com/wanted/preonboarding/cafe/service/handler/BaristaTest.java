package com.wanted.preonboarding.cafe.service.handler;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaristaTest {

    @Test
    public void 주문내역을_바탕으로_커피를_제조한다() {
        // given
        Barista barista = new Barista(0, 0);
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Menu.AMERICANO, 1));
        orders.add(new Order(Menu.ICE_CHOCO, 1));

        // when
        String makeCoffee = barista.makeCoffeeTo(orders);

        // then
        assertThat(makeCoffee).isEqualTo("AMERICANO:1 ICE_CHOCO:1 ");

    }
}