package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.Ticket;
import com.wanted.preonboarding.theater.service.handler.TicketPolicies;

import java.util.ArrayList;
import java.util.List;

public class TestTicketPolices implements TicketPolicies {
    private static final List<Ticket> t = new ArrayList<>();
    static {
        for (int i = 0; i < 100; i++) {
            t.add(new Ticket(100L));
        }
    }
    @Override
    public long ticketOfficeAmount() {
        return 10000L;
    }

    @Override
    public List<Ticket> ticketAmount() {

        return t;
    }
}
