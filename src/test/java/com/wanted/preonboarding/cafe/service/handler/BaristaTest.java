package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.domain.Menu;
import com.wanted.preonboarding.cafe.domain.Order;
import com.wanted.preonboarding.cafe.domain.Rank;
import com.wanted.preonboarding.cafe.domain.Status;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class BaristaTest {
    @Test
    @DisplayName("커피를 성공적으로 만듦")
    void makeCoffeeToSuccess() {
        //given
        final Menu menu = Menu.AMERICANO;
        final int count = 2;
        List<Order> orderList = List.of(new Order(menu, count));

         Barista barista = new Barista(Rank.BEGINNER, Status.WAITING);

        //when
        String result = barista.makeCoffeeTo(orderList);

        String[] orderArr = result.split(":");
        String expectedMenu = orderArr[0];
        int expectedCount = Integer.parseInt(orderArr[1]);

        //then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(expectedMenu).isEqualTo(menu.name());
            softAssertions.assertThat(expectedCount).isEqualTo(count);
        });
    }

    @Test
    @DisplayName("바리스타는 현재 바쁨")
    void isBusy() {
        //given
        Barista barista = new Barista(Rank.BEGINNER, Status.MAKING);

        //when
        boolean result = barista.isBusy();

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("바리스타는 현재 바쁘지 않음")
    void isNotBusy() {
        //given
        Barista barista = new Barista(Rank.BEGINNER, Status.WAITING);

        //when
        boolean result = barista.isBusy();

        //then
        assertThat(result).isFalse();
    }
}