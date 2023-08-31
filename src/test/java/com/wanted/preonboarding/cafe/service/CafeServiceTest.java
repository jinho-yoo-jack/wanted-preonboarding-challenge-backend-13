package com.wanted.preonboarding.cafe.service;

import static org.assertj.core.api.Assertions.*;

import com.wanted.preonboarding.cafe.service.handler.domain.Drink;
import com.wanted.preonboarding.cafe.service.handler.dto.CafeOrderResultDto;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CafeServiceTest {

    @Autowired
    CafeService cafeService;

    @Test
    @DisplayName("고객이 커피를 주문한다.")
    void orderFrom() {
        // given
        Map<Drink, Integer> menus = new HashMap<>();
        menus.put(Drink.AMERICANO, 3);
        menus.put(Drink.LATTE, 5);

        // when
        CafeOrderResultDto resultDto = cafeService.orderFrom(menus);

        // then
        assertThat(resultDto.getTotalPrice()).isEqualTo(13000);
        assertThat(resultDto.getItems()).hasSize(2)
                .extracting("menuName", "quantity", "isMade")
                .containsAnyOf(
                        tuple("AMERICANO", 3, true),
                        tuple("LATTE", 5, true)
                );
    }

}