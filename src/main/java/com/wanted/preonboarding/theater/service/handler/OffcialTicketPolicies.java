package com.wanted.preonboarding.theater.service.handler;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class OffcialTicketPolicies implements TicketPolicies{
    private static final List<Ticket> t = new ArrayList<>();
    static {
        IntStream.range(0, 100).forEach(i -> t.add(new Ticket(100L)));
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
