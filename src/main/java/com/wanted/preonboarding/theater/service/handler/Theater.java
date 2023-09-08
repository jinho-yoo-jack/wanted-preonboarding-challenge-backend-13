package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class Theater {

    private final TicketOffice ticketOffice;

    public String enter(Audience audience) {
        handleEnterAudience(audience);
        return "Have a good time " + audience.getName()+ ".";
    }

    public String refund(Audience audience) {
        handleRefundAudience(audience);
        return audience.getName() + "'s refund success";
    }

    private void handleEnterAudience(Audience audience) {
        if (audience.hasInvitation()) {
            handleInvitation(audience);
            return;
        }
        handlePurchase(audience);
    }

    private void handleRefundAudience(Audience audience) {
        if (refundInvitationTicket(audience)) return;
        this.refundTicketTo(audience);
    }

    // 관객이 초대권이 있다면, 초대권과 티켓을 교환하여 관객에게 지급.
    private void handleInvitation(Audience audience) {
        Invitation invitation = audience.getInvitation();
        invitation.verifyInvitation();

        Ticket freeTicket = this.getAvailableTicket();
        audience.takeTicket(freeTicket);
    }

    // 초대권이 없으면 판매원에게 티켓을 사서 관객에게 지급.
    private void handlePurchase(Audience audience) {
        this.sellToTicket(audience);
    }

    private boolean refundInvitationTicket(Audience audience) {
        if (audience.hasInvitation() && audience.isValidInvitation()) {
            Ticket refundTicket = audience.refundTicket();
            this.setTicket(refundTicket);
            return true;
        }
        return false;
    }

    private Ticket getAvailableTicket() {
        return this.ticketOffice.getAvailableTicket();
    }

    private void sellToTicket(Audience audience) {
        this.ticketOffice.sellTicketTo(audience);
    }

    private void setTicket(Ticket ticket) {
        this.ticketOffice.setTicket(ticket);
    }

    private void refundTicketTo(Audience audience) {
        this.ticketOffice.refundTicketTo(audience);
    }
}
