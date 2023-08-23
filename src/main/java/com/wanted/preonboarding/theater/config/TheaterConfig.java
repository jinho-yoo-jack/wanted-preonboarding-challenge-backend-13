package com.wanted.preonboarding.theater.config;

import com.wanted.preonboarding.theater.service.handler.Ticket;
import com.wanted.preonboarding.theater.service.handler.TicketOffice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TheaterConfig {

    @Bean
    public TicketOffice ticketOffice() {
        return new TicketOffice(10000L, getTickets());
    }

    private List<Ticket> getTickets() {
        return List.of(new Ticket(100L));
    }
}
