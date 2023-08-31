package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.controller.AudienceDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TheaterServiceTest {
    @Autowired
    private TheaterService theaterService;

    @Test
    void enter() {
        AudienceDTO audienceDTO = new AudienceDTO(100L, "2023-08-11-14");
        String enter = theaterService.enter(audienceDTO);

        assertThat(enter).isEqualTo("Have a good time.");
    }

    @Test
    void enter_to_not_invit() {
        AudienceDTO audienceDTO = new AudienceDTO(100L);
        String enter = theaterService.enter(audienceDTO);

        assertThat(enter).isEqualTo("Have a good time.");
    }
}