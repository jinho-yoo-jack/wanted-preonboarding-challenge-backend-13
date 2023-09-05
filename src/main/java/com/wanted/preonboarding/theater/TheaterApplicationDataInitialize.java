package com.wanted.preonboarding.theater;

import com.wanted.preonboarding.theater.audience.service.AudienceService;
import com.wanted.preonboarding.theater.audience.domain.Audience;
import com.wanted.preonboarding.theater.audience.domain.Bag;
import com.wanted.preonboarding.theater.audience.domain.Invitation;
import com.wanted.preonboarding.theater.ticket.service.TicketService;
import com.wanted.preonboarding.theater.ticket.domain.Ticket;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TheaterApplicationDataInitialize {
    private final AudienceService audienceService;
    private final TicketService ticketService;

    @PostConstruct
    public void init() {
        List<Ticket> tickets = List.of(new Ticket(100L));
        for (Ticket ticket : tickets) {
            ticketService.add(ticket);
        }

        // Invitation이 없는 관객
        Bag bagWithoutInvitation = new Bag( 10000L);
        Audience audienceWithoutInvitation = new Audience(bagWithoutInvitation);
        audienceService.add(audienceWithoutInvitation);

        // Invitation이 있는 관객
        Invitation invitationWithInvitation = new Invitation(LocalDateTime.now());
        Bag bagWithInvitation = new Bag(invitationWithInvitation, 10000L);
        Audience audienceWithInvitation = new Audience(bagWithInvitation);
        audienceService.add(audienceWithInvitation);

        log.info("최초 추가된 정보는 다음과 같습니다");

        List<Ticket> findTickets = ticketService.findAll();
        List<Long> ticketIds = findTickets.stream().map(Ticket::getId).toList();
        log.info("티켓  ID : " + ticketIds);

        List<Audience> findAudiences = audienceService.findAll();
        List<Long> audienceIds = findAudiences.stream().map(Audience::getId).toList();
        log.info("관객 ID : " + audienceIds);
    }


}
