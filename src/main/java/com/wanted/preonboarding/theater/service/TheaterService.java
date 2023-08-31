package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.controller.AudienceDTO;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(AudienceDTO audienceDTO) {
        //초대권이 있을 때
        if (audienceDTO.hasInvitation()) {
            LocalDateTime invitationDate = getInvitationDate(audienceDTO);
            Bag bag = new Bag(new Invitation(invitationDate), new Money(audienceDTO.getBagAmount()));
            Audience audience = new Audience(bag);
            theater.changeInvitation(audience);
            theater.enter(audience);
        }

        Bag bag = new Bag(new Money(audienceDTO.getBagAmount()));
        Audience audience = new Audience(bag);
        theater.sellTicketTo(audience);
        return theater.enter(audience);
    }

    private static LocalDateTime getInvitationDate(AudienceDTO audienceDTO) {
        String invitation = audienceDTO.getInvitation();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH");
        return LocalDateTime.parse(invitation, dateTimeFormatter);
    }
}
