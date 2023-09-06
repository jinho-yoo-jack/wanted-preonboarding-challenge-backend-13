package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.Theater;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class TheaterServiceTest {
    @InjectMocks
    TheaterService theaterService;

    @Mock
    Theater theater;

    @Test
    @DisplayName("영화관에 입장시킨다.")
    void enter() {
        // given

        // when

        // then
    }
}