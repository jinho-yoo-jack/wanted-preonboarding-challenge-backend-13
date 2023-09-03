package com.wanted.preonboarding.theater.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TheaterOpen {
    @Bean
    public Theater wantedTheaterOpen() {
        Long showFee = 3000L;

        return Theater.builder()
                .showFee(showFee)
                .ticketOffice(new TicketOffice(0L, new Ticket(showFee)))
                .build();
    }
}
