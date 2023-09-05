package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.AudienceMapper;
import com.wanted.preonboarding.theater.exception.TheaterErrorCode;
import com.wanted.preonboarding.theater.exception.TheaterException;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Transactional
@Service
public class TheaterServiceImpl implements TheaterService {

    private final Theater theater;
    private final TicketSeller ticketSeller;
    private final AudienceMapper audienceMapper;

    public String enter(AudienceDto audienceDto) {
        Audience audience = audienceMapper.toEntity(audienceDto);
        Optional<Invitation> invitation = audience.getInvitation();
        if (invitation.isPresent()) {
            Invitation validInvitation = invitation.orElseThrow(() -> new TheaterException(TheaterErrorCode.NOT_FOUND_INVITATION));
            validInvitation.verifyInvitation();
            handleInvitation(audience, validInvitation);
        } else if (ticketSeller.verifyAudienceGotMoney(audience)) {
            handleTicketPurchase(audience);
        } else {
            throw new TheaterException(TheaterErrorCode.NOT_ENOUGH_MONEY, audience.getName()+"'s money:"+audience.getMoney());
        }

        return theater.enterSuccess(audience);
    }

    public String refund(AudienceDto audienceDto) {
        Audience audience = audienceMapper.toEntity(audienceDto);
        audience.hasTicket();
        Ticket ticket = audience.getTicket();
        if (audience.getInvitation().isPresent()) {
            audience.removeTicket();
            ticketSeller.ticketOffice().setTicket(ticket);
        }
        audience.refundTicket(ticket);
        ticketSeller.removeAmount(ticket.getFee());

        return audience.getName() + "'s refund success";
    }

    // 관객이 초대권이 있다면, 초대권과 티켓을 교환하여 관객에게 지급.
    private void handleInvitation(Audience audience, Invitation invitation) {
        invitation.modifyUsed();
        Ticket ticket = ticketSeller.getTicket();
        audience.takeTicket(ticket);
    }

    // 초대권이 없으면 판매원에게 티켓을 사서 관객에게 지급.
    private void handleTicketPurchase(Audience audience) {
        Ticket ticket = ticketSeller.getTicket();
        audience.purchaseTicket(ticket);
        ticketSeller.addAmount(ticket.getFee());
        audience.takeTicket(ticket);
    }
}
