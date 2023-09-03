package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Theater {

    private final Long TICKET_FEE = 100L;
    private final TicketSeller ticketSeller
            = new TicketSeller(new TicketOffice(20000L, new Ticket(TICKET_FEE)));
    public boolean enter(Audience audience){
        return audience.hasTicket();
    }

    public Long getTICKET_FEE() {
        return TICKET_FEE;
    }

    public Ticket sellTicket() {
        return ticketSeller.sellTicket(TICKET_FEE);
    }

    public Optional<Ticket> checkInvitation(Invitation invitation) {
        LocalDateTime now = LocalDateTime.now();
        Optional<Ticket> optional = Optional.empty();
        if(now.isBefore(invitation.getWhen()) || now.isEqual(invitation.getWhen())) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            optional = Optional.ofNullable(ticket);
        }
        return optional;
    }

}
