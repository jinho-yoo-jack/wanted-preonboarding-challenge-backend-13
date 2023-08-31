package com.wanted.preonboarding.theater.service.handler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicketTest {

    @Test
    void getFee() {
        Money money = new Money(10000L);
        Ticket ticket = new Ticket(10000L);
        assertEquals(money, ticket.getFee());
    }
}