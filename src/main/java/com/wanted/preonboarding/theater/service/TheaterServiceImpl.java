package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.AudienceMapper;
import com.wanted.preonboarding.theater.exception.TheaterErrorCode;
import com.wanted.preonboarding.theater.exception.TheaterException;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@Service
public class TheaterServiceImpl implements TheaterService {

    private final Theater theater;
    private final AudienceMapper audienceMapper;

    public String enter(AudienceDto audienceDto) {
        Audience audience = audienceMapper.toEntity(audienceDto);

        if (audience.hasInvitation()) {
            handleInvitation(audience);
        } else {
            handlePurchase(audience);
        }

        return theater.enterSuccess(audience);
    }

    public String refund(AudienceDto audienceDto) {
        Audience audience = audienceMapper.toEntity(audienceDto);
        audience.validHasTicket();
        TicketOffice ticketOffice = theater.getTicketOffice();
        TicketSeller ticketSeller = ticketOffice.findAvailableTicketSeller();
        Ticket ticket = audience.getTicket();
        if (audience.hasInvitation() && audience.getInvitation().get().isUsed()) {
            audience.removeTicket();
            ticketOffice.setTicket(ticket);
        } else {
            audience.refundTicket(ticket);
            ticketSeller.refundTicketTo(ticketOffice, ticket);
        }

        return audience.getName() + "'s refund success";
    }

    // 관객이 초대권이 있다면, 초대권과 티켓을 교환하여 관객에게 지급.
    private void handleInvitation(Audience audience) {
        Invitation invitation = audience.getInvitation().orElseThrow(() -> new TheaterException(TheaterErrorCode.NOT_FOUND_INVITATION));
        invitation.verify();

        Ticket freeTicket = theater.getTicketOffice().getTicket();
        audience.takeTicket(freeTicket);
    }

    // 초대권이 없으면 판매원에게 티켓을 사서 관객에게 지급.
    private void handlePurchase(Audience audience) {
        TicketOffice ticketOffice = theater.getTicketOffice();
        TicketSeller ticketSeller = ticketOffice.findAvailableTicketSeller();
        long ticketPrice = ticketOffice.getTicketPrice();

        if (audience.getMoney() < ticketPrice) {
            throw new TheaterException(TheaterErrorCode.NOT_ENOUGH_MONEY);
        }

        Ticket ticket = ticketOffice.getTicket();
        ticketSeller.sellTicketTo(audience, ticket);
        ticketOffice.plusAmount(ticketPrice);
    }
}
