package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class Theater {

    private final TicketOffice ticketOffice;

    public String enter(Audience audience) {
        handleEnter(audience);
        return "Have a good time " + audience.getName()+ ".";
    }

    public String refund(Audience audience) {
        handleRefund(audience);
        return audience.getName() + "'s refund success";
    }

    private void handleEnter(Audience audience) {
        if (audience.hasInvitation()) {
            handleInvitation(audience);
            return;
        }
        this.ticketOffice.sellTicketTo(audience);
    }

    private void handleRefund(Audience audience) {
        if (audience.hasInvitation() && audience.isValidInvitation()) {
            Ticket refundTicket = audience.refundTicket();
            this.ticketOffice.setTicket(refundTicket);
            return;
        }
        this.ticketOffice.refundTicketTo(audience);
    }

    // 관객이 초대권이 있다면, 초대권과 티켓을 교환하여 관객에게 지급.
    private void handleInvitation(Audience audience) {
        Invitation invitation = audience.getInvitation();
        invitation.verifyInvitation();

        Ticket freeTicket = this.ticketOffice.getAvailableTicket();
        audience.takeTicket(freeTicket);
    }
}
