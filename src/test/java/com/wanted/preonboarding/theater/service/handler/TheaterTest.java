package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.domain.AudienceRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TheaterTest {

    @Autowired
    private Theater theater;

    @Test
    public void 입장_통과_초대권소지(){
        AudienceRequestDto rm = AudienceRequestDto.builder()
                .when(LocalDateTime.now())
                .amount(0L)
                .build();
        Audience audience = new Audience(rm);
        theater.enter(audience);
        assertThat(audience.hasInvitation()).isTrue();
    }

    @Test
    public void 입장불가_금액부족(){
        AudienceRequestDto rm = AudienceRequestDto.builder()
                .when(null)
                .amount(0L)
                .build();
        Assertions.assertThrows(RuntimeException.class, () ->{
            theater.enter(new Audience(rm));
        });
    }

    @Test
    public void 입장_통과_티켓구매(){
        AudienceRequestDto rm = AudienceRequestDto.builder()
                .when(null)
                .amount(50000L)
                .build();
        Audience audience = new Audience(rm);
        theater.enter(audience);
        assertThat(audience.hasInvitation()).isFalse();
        assertThat(audience.getAmount()).isEqualTo(50000L - 100);
    }
}