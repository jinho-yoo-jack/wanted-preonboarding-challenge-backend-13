package com.wanted.preonboarding.theater.config;

import com.wanted.preonboarding.theater.service.handler.Ticket;
import com.wanted.preonboarding.theater.service.handler.TicketOffice;
import com.wanted.preonboarding.theater.service.handler.TicketSeller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TheaterConfig {

    @Bean
    public TicketSeller ticketSellerConfig() {
        return new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));
    }

}