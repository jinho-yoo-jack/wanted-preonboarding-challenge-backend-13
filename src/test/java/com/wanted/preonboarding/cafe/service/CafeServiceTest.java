package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.CustomerRequest;
import com.wanted.preonboarding.cafe.dto.CustomerRequestDto;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CafeServiceTest {

    @InjectMocks
    CafeService cafeService;

    @Mock
    Cafe cafe;

    @Test
    @DisplayName("사용자의 주문을 받는다.")
    void test() {
        // given
        CustomerRequestDto requestDto = new CustomerRequestDto(List.of(new CustomerRequest("AMERICANO", 1L)));

        // when
        cafeService.orderFrom(requestDto);

        // then
    }
}