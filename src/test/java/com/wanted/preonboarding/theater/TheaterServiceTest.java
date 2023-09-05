package com.wanted.preonboarding.theater;

import com.wanted.preonboarding.theater.TheaterConfig;
import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Bag;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import com.wanted.preonboarding.theater.service.handler.Theater;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest(classes = {TheaterConfig.class, TheaterService.class, Theater.class})
public class TheaterServiceTest {

    @Autowired
    private TheaterConfig theaterConfig;

    @Autowired
    private TheaterService theaterService;

    @Autowired
    private Theater theater;

    @DisplayName("초대권이 있는 경우")
    @Test
    public void haveInvitation(){
        Long amountBefore = theater.getAssets();
        Invitation invitation = new Invitation(LocalDateTime.now());
        Bag bag = new Bag(invitation, 10000L);
        Audience audience = new Audience(bag);

        theaterService.enter(audience);

        assert bag.hasTicket();
        assert bag.getAmount() == 10000L;
        assert theater.getAssets().equals(amountBefore);
    }

    @DisplayName("초대권이 없는 경우")
    @Test
    public void noInvitation(){
        Long amountBefore = theater.getAssets();
        Bag bag = new Bag(10000L);
        Audience audience = new Audience(bag);

        theaterService.enter(audience);

        assert bag.hasTicket();
        assert bag.getAmount() == (10000L - theaterConfig.getTicketFee());
        assert theater.getAssets().equals(amountBefore + theaterConfig.getTicketFee());
    }
}
