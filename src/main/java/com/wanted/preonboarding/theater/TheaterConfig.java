package com.wanted.preonboarding.theater;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Theater;
import com.wanted.preonboarding.theater.service.handler.Ticket;
import com.wanted.preonboarding.theater.service.handler.TicketOffice;
import com.wanted.preonboarding.theater.service.handler.TicketSeller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TheaterConfig {

    @Bean
    public TicketSeller ticketSeller() {
        return new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));
    }

    @Bean
    public Theater theater() {
        return new Theater(ticketSeller());
    }

}
