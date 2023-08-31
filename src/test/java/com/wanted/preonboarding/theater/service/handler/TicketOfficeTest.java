package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.service.TestTicketPolices;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicketOfficeTest {
    @Test
    void changeInvitiactionByTicket() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(100L));
        TicketOffice ticketOffice = new TicketOffice(new TestTicketPolices());

        Audience audience = new Audience(new Bag(new Money(100L)));
        Ticket ticket = ticketOffice.changeInvitiactionByTicket(audience);
        assertEquals(new Money(100L), ticket.getFee());
    }

    @Test
    void sellTicketTo() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(100L));
        TicketOffice ticketOffice = new TicketOffice(new TestTicketPolices());

        boolean b = ticketOffice.sellTicketTo(new Audience(new Bag(new Money(100L))));
        assertTrue(b);
    }

}