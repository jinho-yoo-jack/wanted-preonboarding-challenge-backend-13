package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.service.TestTicketPolices;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TicketSellerTest {

    @Test
    void sellTicketTo() {
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(new TestTicketPolices()));
        Audience audience = new Audience(new Bag(new Money(100L)));
        boolean b = ticketSeller.sellTicketTo(audience);
        assertTrue(b);
    }
}