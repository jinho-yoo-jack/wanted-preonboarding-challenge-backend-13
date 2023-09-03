package com.wanted.preonboarding.theater;

import com.wanted.preonboarding.theater.domain.Ticket;
import com.wanted.preonboarding.theater.domain.TicketOffice;
import com.wanted.preonboarding.theater.domain.TicketSeller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitTheater {

    @Bean
    public TicketSeller ticketSeller() {
        TicketOffice ticketOffice = new TicketOffice(20000L, new Ticket(100L));
        return new TicketSeller(ticketOffice);
    }
}
