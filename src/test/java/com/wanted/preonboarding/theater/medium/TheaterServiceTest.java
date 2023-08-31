package com.wanted.preonboarding.theater.medium;

import com.wanted.preonboarding.theater.dto.RequestMessage;
import com.wanted.preonboarding.theater.service.TheaterService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class TheaterServiceTest {

    @Autowired
    private TheaterService theaterService;
    
    @Test
    public void 초대권이_있으면_입장() {
        // given
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setAmount(10000L);
        requestMessage.setInvitationAt(LocalDateTime.of(2023, 12, 31, 0, 0, 0));

        // when
        String msg = theaterService.enter(requestMessage);

        // then
        Assertions.assertThat(msg).isEqualTo("Have a good time.");
    }

    @Test
    public void 초대권이_없어도_입장() {
        // given
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setAmount(10000L);

        // when
        String msg = theaterService.enter(requestMessage);

        // then
        Assertions.assertThat(msg).isEqualTo("Have a good time.");
    }

}
