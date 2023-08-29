package com.wanted.preonboarding.theather.service;

import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Theater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class TheaterServiceTest {

    private final static String ENTERED_MESSAGE = "Have a good time.";

    @InjectMocks
    private TheaterService theaterService;

    @Mock
    private Theater theater;

    @ParameterizedTest
    @MethodSource("providedAudiences")
    public void enter_Success_초대권티켓이_있든없든_입장가능(Long amount, LocalDateTime invitedAt) throws Exception {

        //given
        Audience audience = Audience.of(amount, invitedAt);

        //when
        String message = theaterService.enter(audience);

        //then
        Assertions.assertEquals(ENTERED_MESSAGE, message);
    }

    public static Stream<Arguments> providedAudiences() {
        return Stream.of(
                Arguments.of(1000L, null),
                Arguments.of(1000L, "2023-01-01T10:10:10")
        );
    }
}