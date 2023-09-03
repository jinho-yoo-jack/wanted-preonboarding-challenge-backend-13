package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.domain.Cafe;
import com.wanted.preonboarding.cafe.domain.Menu;
import com.wanted.preonboarding.cafe.domain.Order;
import com.wanted.preonboarding.cafe.domain.PaymentType;
import com.wanted.preonboarding.cafe.dto.OrderRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CafeServiceTest {
    @InjectMocks
    private CafeService cafeService;

    @Mock
    private Cafe cafe;

    @Test
    @DisplayName("환영 인사에성공함")
    void greet() {
        //given
        final String expectedMessage = "Welcome to The cafe!!";

        given(cafe.welcomeMessage()).willReturn(expectedMessage);

        //when
        String result = cafeService.greet();

        //then
        assertThat(result).isEqualTo(expectedMessage);
    }

    @Test
    @DisplayName("주문에 성공함")
    void orderSuccess() {
        //given
        OrderRequest orderRequest = new OrderRequest(PaymentType.CASH, List.of(new Order(Menu.AMERICANO, 2)));
        String expectedResponse = "AMERICANO:2";

        given(cafe.orderReception(any(OrderRequest.class))).willReturn(expectedResponse);

        //when
        String response = cafeService.orderFrom(orderRequest);

        //then
        assertThat(response).isEqualTo(expectedResponse);
    }

    @Test
    @DisplayName("바리스타가 바빠 주문에 실패함")
    void orderFailed() {
        //given
        OrderRequest orderRequest = new OrderRequest(PaymentType.CASH, new ArrayList<>());

        given(cafe.orderReception(any(OrderRequest.class))).willThrow(IllegalStateException.class);

        //when & then
        assertThrows(IllegalStateException.class, () -> cafeService.orderFrom(orderRequest));
    }
}