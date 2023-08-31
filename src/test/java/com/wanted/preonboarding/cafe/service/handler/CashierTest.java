package com.wanted.preonboarding.cafe.service.handler;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CashierTest {

    @Test
    public void 주문내역을_바탕으로_커피값을_구한다() {
        // given
        Cashier cashier = new Cashier(new Cafe());

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Menu.AMERICANO, 1));
        orders.add(new Order(Menu.ICE_CHOCO, 1));

        // when
        long price = cashier.calculateTotalPrice(orders);

        // then
        assertThat(price).isEqualTo(8600L);
    }

    @Test
    public void 주문내역을_바탕으로_주문처리를_한다() {
        // given
        Cafe cafe = new Cafe();
        Cashier cashier = new Cashier(cafe);

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Menu.AMERICANO, 1));
        orders.add(new Order(Menu.ICE_CHOCO, 1));

        // when
        cashier.takeOrder(orders, 8600L);

        // then
        assertThat(cafe.getSales()).isEqualTo(18600L);
    }
}