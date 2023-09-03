package com.wanted.preonboarding.theater.handler;

import com.wanted.preonboarding.theater.entity.Ticket;
import com.wanted.preonboarding.theater.entity.TicketOffice;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(){
        this.ticketOffice  = TicketOffice.builder()
                .amount(20000L)
                .tickets(List.of(new Ticket(100L)))
                .build();
    }

    public TicketOffice getTicketOffice(){
        return ticketOffice;
    }
}
