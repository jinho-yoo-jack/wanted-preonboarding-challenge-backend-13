package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.exception.TheaterErrorCode;
import com.wanted.preonboarding.theater.exception.TheaterException;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final Theater theater;
    private final TicketSeller ticketSeller;

    public String enter(AudienceDto audienceDto) {
        Audience audience = audienceDto.of();
        Optional<Invitation> invitation = audience.getInvitation();
        if (invitation.isPresent()) {
            Invitation validInvitation = verifyInvitation(invitation);
            handleInvitation(audience, validInvitation);
        } else if (ticketSeller.verifyAudienceGotMoney(audience)) {
            handleTicketPurchase(audience);
        } else {
            throw new TheaterException(TheaterErrorCode.NOT_ENOUGH_MONEY, audience.name()+"'s money:"+audience.getMoney());
        }

        return theater.enterSuccess(audience);
    }

    public String refund(AudienceDto audienceDto) {
        Audience audience = audienceDto.of();
        hasTicket(audience);
        Ticket ticket = audience.getTicket();
        if (audience.getInvitation().isPresent()) {
            audience.removeTicket();
            ticketSeller.ticketOffice().setTicket(ticket);
        }
        audience.refundTicket(ticket);
        ticketSeller.removeAmount(ticket.getFee());

        return audience.name() + "'s refund success";
    }

    // 초대권을 사용했는지, 유효기간이 지났는지 검증.
    private Invitation verifyInvitation(Optional<Invitation> invitation) {
        Invitation target = invitation.orElseThrow(() -> new TheaterException(TheaterErrorCode.NOT_FOUND_INVITATION));
        if (target.isUsed()) {
            throw new TheaterException(TheaterErrorCode.INVITATION_ALREADY_USED);
        } else if (target.getWhen().isBefore(LocalDateTime.now())) {
            throw new TheaterException(TheaterErrorCode.INVITATION_EXPIRED);
        }
        return target;
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

    private static void hasTicket(Audience audience) {
        if (!audience.hasTicket()) {
            throw new TheaterException(TheaterErrorCode.NOT_FOUND_TICKET);
        }
    }
}
