package com.wanted.preonboarding.cafe.domain;

import com.wanted.preonboarding.cafe.domain.*;
import com.wanted.preonboarding.cafe.dto.OrderRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CafeTest {

    @Test
    @DisplayName("환영 인사를 해줌")
    void welcomeMessage() {
        //given
        Cafe cafe = 카페_오픈();
        final String expectedMessage = String.format("Welcome to The %s!!", cafe.getName());

        //when
        String result = cafe.welcomeMessage();

        //then
        assertThat(result).isEqualTo(expectedMessage);
    }

    @Test
    @DisplayName("카페 매출이 증가함")
    void plusSales() {
        //given
        Cafe cafe = 카페_오픈();
        final Long amount = 3000L;
        final Long expectedAmount = cafe.getSales() + amount;

        //when
        cafe.plusSales(amount);

        //then
        assertThat(cafe.getSales()).isEqualTo(expectedAmount);
    }

    @Test
    @DisplayName("카페 매출이 감소함")
    void minusSales() {
        //given
        Cafe cafe = 카페_오픈();
        final Long amount = 3000L;
        final Long expectedSales = cafe.getSales() - amount;

        //when
        cafe.minusSales(amount);

        //then
        assertThat(cafe.getSales()).isEqualTo(expectedSales);
    }

    @Test
    @DisplayName("주문이 성공적으로 만들어짐")
    void orderReceptionSuccess() {
        //given
        Cafe cafe = 카페_오픈();

        final Menu menu = Menu.AMERICANO;
        final int count = 2;
        final PaymentType paymentType = PaymentType.CASH;
        final Order order = new Order(menu, count);

        OrderRequest orderRequest = new OrderRequest(paymentType, List.of(order));

        //when
        String response = cafe.orderReception(orderRequest);

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
    @DisplayName("주문에 대한 제조에 실패함")
    void orderReceptionFailed() {
        //given
        Cafe cafe = 카페_오픈(Status.MAKING);

        OrderRequest orderRequest = new OrderRequest(PaymentType.CASH, new ArrayList<>());

        //when
        assertThrows(IllegalStateException.class, () -> cafe.orderReception(orderRequest));
    }

    private Cafe 카페_오픈() {
        return 카페_오픈(Status.WAITING);
    }

    private Cafe 카페_오픈(Status baristaStatus) {
        return Cafe.builder()
                .name("cafe")
                .sales(3000L)
                .barista(new Barista(Rank.BEGINNER, baristaStatus))
                .cashier(new Cashier())
                .build();
    }
}