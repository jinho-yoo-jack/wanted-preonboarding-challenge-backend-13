package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.entity.BeverageType;
import com.wanted.preonboarding.cafe.entity.Order;
import com.wanted.preonboarding.cafe.entity.OrderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CafeServiceTest {
    @Autowired
    private CafeService cafeService;
    @Autowired
    private Order order;

    @Test
    @DisplayName("아메리카노 3 잔 주문 호출")
    public void testOrderFrom(){

        // GIVEN
        String americanoName = BeverageType.AMERICANO.name();
        Integer americanoAmount = 3;
        OrderItem item = OrderItem.builder()
                .name(americanoName)
                .amount(americanoAmount)
                .build();
        order.addComponent(item, item.getAmount());

        // WHEN
        String result = cafeService.orderFrom(order);

        // THEN
        System.out.println("result : "+result);
        Assertions.assertEquals(result, "AMERICANO:3");
    }
}