package com.wanted.preonboarding.theater;

import com.wanted.preonboarding.theater.service.handler.Ticket;
import com.wanted.preonboarding.theater.service.handler.TicketOffice;
import com.wanted.preonboarding.theater.service.handler.TicketSeller;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Getter
@Configuration
public class TheaterConfig {

    @Value("${theater.ticket.fee}")
    private Long ticketFee;
    @Value("${theater.ticket-office.ticket.count}")
    private Long ticketCount;
    @Value("${theater.ticket-office.amount}")
    private Long amount;

    @Bean
    public TicketSeller ticketSeller() {

        List<Ticket> tickets = new ArrayList();
        for (long i=0; i <= ticketCount; i++) {
            tickets.add(new Ticket(ticketFee));
        }

        TicketOffice ticketOffice = new TicketOffice(amount, tickets);

        return new TicketSeller(ticketOffice);
    }
}
