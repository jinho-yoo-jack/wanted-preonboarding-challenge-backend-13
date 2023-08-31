package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.OrderCafeFixture;
import com.wanted.preonboarding.cafe.dto.request.OrderCustomerRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CafeServiceTest {


    @Autowired
    private CafeService cafeService;

    // 음료 주문하기 성공
    @Test
    @DisplayName("커피 주문하기 성공")
    void successOrderCoffee() {

        // given
        OrderCustomerRequest request = OrderCafeFixture.SUCCESS_ORDER_REQUEST;

        // when
        String resultMessage = cafeService.orderFrom(request);
        String expectedMessage = "AMERICANO:3\nESPRESSO:2\nLATTE:1\n";

        // then
        assertEquals(expectedMessage, resultMessage);

    }

}