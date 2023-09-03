package com.wanted.preonboarding.cafe.domain;

import com.wanted.preonboarding.cafe.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CashierTest {

    @Test
    @DisplayName("주문에 대한 총 액 계산")
    void calculateTotalPrice() {
        //given
        Cashier cashier = new Cashier();

        Order firstOrder = new Order(Menu.AMERICANO, 2);    // 100 * 2 = 200
        Order secondOrder = new Order(Menu.CAFE_LATTE, 1);  // 200 * 1 = 200
        List<Order> orderList = List.of(firstOrder, secondOrder);

        long expectedAmount = 400L;

        //when
        long totalAmount = cashier.calculateTotalPrice(orderList);

        //then
        assertThat(totalAmount).isEqualTo(expectedAmount);
    }

    @Test
    @DisplayName("바쁘지 않은 바리스타에게 요청한 주문을 정상적으로 응답 받음")
    void sendTo() {
        //given
        Cashier cashier = new Cashier();
        Barista barista = new Barista(Rank.BEGINNER, Status.WAITING);

        final Menu menu = Menu.AMERICANO;
        final int count = 2;
        List<Order> orderList = List.of(new Order(menu, count));

        //when
        String response = cashier.sendTo(barista, orderList);

        String[] orderArr = response.split(":");
        String expectedMenu = orderArr[0];
        int expectedCount = Integer.parseInt(orderArr[1]);

        //then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(expectedMenu).isEqualTo(menu.name());
            softAssertions.assertThat(expectedCount).isEqualTo(count);
        });
    }

    @Test
    @DisplayName("바쁜 바리스타에게 주문 요청 실패")
    void sendToFailed() {
        //given
        Cashier cashier = new Cashier();
        Barista barista = new Barista(Rank.BEGINNER, Status.MAKING);

        List<Order> orderList = new ArrayList<>();

        //when & then
        assertThrows(IllegalStateException.class, () -> cashier.sendTo(barista, orderList));
    }
}