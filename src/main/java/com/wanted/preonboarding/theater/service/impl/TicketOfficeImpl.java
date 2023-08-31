package com.wanted.preonboarding.theater.service.impl;

import com.wanted.preonboarding.theater.service.TicketOffice;
import com.wanted.preonboarding.theater.service.handler.Ticket;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketOfficeImpl implements TicketOffice {
    private long amount = 20000L;
    private final List<Ticket> tickets = List.of(new Ticket(100L));

    @Override
    public Ticket getTicket(){
        return tickets.get(0);
    }

    @Override
    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    @Override
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
