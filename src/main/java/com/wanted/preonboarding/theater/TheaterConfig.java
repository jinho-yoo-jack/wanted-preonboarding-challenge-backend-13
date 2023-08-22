package com.wanted.preonboarding.theater;

import com.wanted.preonboarding.theater.service.handler.Ticket;
import com.wanted.preonboarding.theater.service.handler.TicketOffice;
import com.wanted.preonboarding.theater.service.handler.TicketSeller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TheaterConfig {

    @Bean
    public TicketOffice ticketOffice() {
        return new TicketOffice(20000L,
                tickets()
        );
    }

    @Bean
    public List<Ticket> tickets() {
        return List.of(
                new Ticket(100L),
                new Ticket(150L),
                new Ticket(200L),
                new Ticket(250L),
                new Ticket(300L),
                new Ticket(350L),
                new Ticket(400L),
                new Ticket(450L),
                new Ticket(500L),
                new Ticket(550L)
        );
    }

    @Bean
    public TicketSeller ticketSeller() {
        return new TicketSeller(ticketOffice());
    }
}
