package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.dto.AudienceInfo;
import lombok.Getter;
import lombok.ToString;

import static com.wanted.preonboarding.theater.service.handler.AudienceState.*;

@Getter
@ToString
public class Audience {

    private AudienceState state;

    private final Bag bag;

    private Audience(Bag bag){

        this.bag = bag;

        if (bag.hasInvitation()) {
            state = INVITED;
        } else if (bag.hasTicket()) {
            state = TICKET_POSSESSION;
        } else {
            state = TICKET_NOT_POSSESSION;
        }
    }

    public static Audience ofRequest(AudienceInfo request) {

        AudienceInfo.BagInfo requestBag = request.getBag();
        if (requestBag == null) {
            throw new RuntimeException();
        }

        AudienceInfo.BagInfo.InvitationInfo requestInvitation = requestBag.getInvitation();
        if (requestInvitation != null) {

            Invitation invitation = new Invitation(requestInvitation.getWhen());
            return new Audience(new Bag(invitation, requestBag.getAmount()));
        } else {
            return new Audience(new Bag(requestBag.getAmount()));
        }
    }

    public void buyTicket(TicketSeller ticketSeller) {

        Ticket ticket = ticketSeller.takeOutTicket();

        bag.minusAmount(ticket.getFee());
        putInTicketMyBag(ticket);

        ticketSeller.putMoney(ticket.getFee());
    }

    public void takeTicket(Ticket ticket) {

        putInTicketMyBag(ticket);
    }

    private void putInTicketMyBag(Ticket ticket) {
        bag.setTicket(ticket);

        if (state != INVITED) {
            state = TICKET_POSSESSION;
        }
    }
}