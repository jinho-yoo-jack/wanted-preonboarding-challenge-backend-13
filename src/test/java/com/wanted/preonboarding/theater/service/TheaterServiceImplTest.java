package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.AudienceMapper;
import com.wanted.preonboarding.theater.service.handler.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TheaterServiceImplTest {

    @InjectMocks TheaterServiceImpl theaterService;
    @Mock Theater theater;
    @Mock AudienceMapper audienceMapper;

    @Test
    @DisplayName("초대권이 없는 관람객의 경우 소지금으로 티켓을 구매하고 입장한다.")
    public void givenAudienceWithoutInvitationWhenEnterThenBuyTicketAndEnterSuccess() throws Exception {
        // given
        AudienceDto audienceDto = new AudienceDto("test", new Bag(1000L));
        Audience audience = new Audience(audienceDto.name(), audienceDto.bag());
        when(audienceMapper.toEntity(audienceDto)).thenReturn(audience);
        when(theater.enter(audience)).thenReturn("Have a good time " + audience.getName() + ".");

        // when
        String result = theaterService.enter(audienceDto);

        // then
        assertThat(result).contains("Have a good time");
        verify(theater, times(1)).enter(audience);
        verify(audienceMapper, times(1)).toEntity(audienceDto);
    }

    @Test
    @DisplayName("초대권이 있는 관람객의 경우 소지금으로 사지 않고 티켓을 받고 입장한다.")
    public void givenAudienceWithInvitationWhenEnterThenJustTakeTicketAndEnterSuccess() throws Exception {
        // given
        new AudienceDto("test", new Bag(1000L));

        // when

        // then
    }

}