package com.wanted.preonboarding.theater;

import com.wanted.preonboarding.theater.service.handler.Theater;
import com.wanted.preonboarding.theater.service.handler.TicketOffice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;


@Configuration
public class TheaterConfig {

    @Bean
    public Theater theater() {
        return new Theater(ticketOffice());
    }

    @Bean
    public TicketOffice ticketOffice() {
        TicketOffice ticketOffice = new TicketOffice(new ArrayList<>(), new ArrayList<>());
        ticketOffice.createTicketSeller(2).forEach(ticketOffice::setTicketSeller);
        ticketOffice.createTicket(100).forEach(ticketOffice::setTicket);
        return ticketOffice;
    }
}
