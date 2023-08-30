package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.domain.MenuRequestDto;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.exception.BadRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CafeServiceTest {

    @Autowired
    private CafeService cafeService;

    @Autowired
    private Cafe cafe;

    @Test
    public void 주문(){
        List<MenuRequestDto> list = new ArrayList<>();
        MenuRequestDto americano = MenuRequestDto.builder()
                .menuName("AMERICANO")
                .quantity(3)
                .build();
        MenuRequestDto iceTea = MenuRequestDto.builder()
                .menuName("ICE_TEA")
                .quantity(3)
                .build();
        MenuRequestDto latte = MenuRequestDto.builder()
                .menuName("LATTE")
                .quantity(1)
                .build();
        list.add(americano);
        list.add(iceTea);
        list.add(latte);
        cafeService.orderFrom(list);
        assertThat(cafe.getSales()).isEqualTo(10000 + 300 + 300 + 200);
    }

    @Test
    public void 주문_메뉴없음(){
        List<MenuRequestDto> list = new ArrayList<>();
        MenuRequestDto americano = MenuRequestDto.builder()
                .menuName("ESPRESSO")
                .quantity(3)
                .build();
        list.add(americano);
        Assertions.assertThrows(BadRequest.class, () ->{
            cafeService.orderFrom(list);
        });
    }
}