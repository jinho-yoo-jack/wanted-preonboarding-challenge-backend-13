package com.wanted.preonboarding.cafe;

import com.wanted.preonboarding.cafe.dto.OrderRequestDto;
import com.wanted.preonboarding.cafe.service.CafeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CafeServiceTest {
    @Autowired
    CafeService cafeService;

    @Test
    @DisplayName("커피 주문")
    public void orderFromTest() {
        OrderRequestDto dto = OrderRequestDto.builder()
                .Americano(1)
                .Espresso(2)
                .Latte(1)
                .build();

        System.out.println(cafeService.orderFrom(dto));
    }
}
