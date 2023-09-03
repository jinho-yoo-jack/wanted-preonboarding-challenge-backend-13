package com.wanted.preonboarding.theater.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Theater {
    private Long showFee;
    private TicketOffice ticketOffice;

    public boolean invitationCheck(Bag bag) {
        return bag.hasInvitation();
    }

    public Ticket ticketOfficeGuide(Long amount) {
        return ticketOffice.ticketIssue(amount);
    }

    public Ticket ticketOfficeGuide() {
        return ticketOffice.ticketIssue();
    }

    public String enter(Ticket ticket) {
        ticket.checkTicket();

        return "Have a good time.";
    }
}
