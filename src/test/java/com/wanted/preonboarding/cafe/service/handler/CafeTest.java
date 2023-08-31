package com.wanted.preonboarding.cafe.service.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CafeTest {

    @DisplayName("주문 테스트")
    @Test
    void takeOrder() {
        // given
        Cafe wantedCafe = new Cafe("Wanted Cafe", 0L, new Cashier());
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("아메리카노", 3);
        Barista barista = new Barista(0, 0);
        Customer customer = new Customer("Card", orders);
        TestMenuStatics testMenuStatics = new TestMenuStatics();

        // when
        wantedCafe.takeOrder(customer, barista, testMenuStatics.getMenu());

        // then
        assertThat(wantedCafe.getSales()).isEqualTo(9000L);
    }

    @DisplayName("메뉴에 없으면 주문할 수 없다.")
    @Test
    void order_fail_if_not_exist_menu() {
        // given
        Cafe wantedCafe = new Cafe("Wanted Cafe", 0L, new Cashier());
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("아메리카노", 3);
        orders.put("카페라떼", 3);
        orders.put("카푸치노", 3);
        Barista barista = new Barista(0, 0);
        Customer customer = new Customer("Card", orders);
        TestMenuStatics testMenuStatics = new TestMenuStatics();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> wantedCafe.takeOrder(customer, barista, testMenuStatics.getMenu()));
    }
}