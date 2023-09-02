package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import com.wanted.preonboarding.theater.service.handler.Theater;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TheaterServiceTest {
    @Autowired
    private Theater theater;

    @Test
    @DisplayName("초대권 티켓이 없는 고객 테스트")
    public void NonInvitationAudienceEnterTest() {
        Audience audience = new Audience(new Bag(1000L));

        theater.enter(audience);

        assertFalse(audience.hasInvitation());
        assertNotEquals(1000L, audience.getBag().getAmount());
        assertNotNull(audience.getBag().getTicket());
    }

    @Test
    @DisplayName("초대권 티켓이 있는 고객 테스트")
    public void invitationAudienceEnterTest() {
        Audience audience = new Audience(new Bag(new Invitation(LocalDateTime.now()), 2000L));

        theater.enter(audience);

        assertTrue(audience.hasInvitation());
        assertEquals(2000L, audience.getBag().getAmount());
    }
}
