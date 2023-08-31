package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CafeServiceTest {


    @DisplayName("주문 테스트")
    @Test
    void orderFrom() {
        // given
        Barista barista = new Barista(0, 0);
        Cashier cashier = new Cashier();
        Cafe wantedCafe = new Cafe("Wanted Cafe", 0L, cashier);
        CafeService cafeService = new CafeService(wantedCafe, barista, new OfficialMenuStatics());
        HashMap<String, Integer> order = new HashMap<>();
        order.put("아메리카노", 3);
        Customer customer = new Customer("Card", order);

        // when
        String result = cafeService.orderFrom(customer);

        // then
        assertEquals("아메리카노:3", result);
    }
}