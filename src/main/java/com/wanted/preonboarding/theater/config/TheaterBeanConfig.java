package com.wanted.preonboarding.theater.config;

import com.wanted.preonboarding.theater.service.handler.Ticket;
import com.wanted.preonboarding.theater.service.handler.TicketOffice;
import com.wanted.preonboarding.theater.service.handler.TicketSeller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TheaterBeanConfig {
    private static final long OFFICE_AMOUNT = 20000L;
    private static final long TICKET_FEE = 100L;

    /**
     * 티켓 관련 기본 설정 bean 등록
     * @return 기본 티켓 판매 클래스 bean
     */
    @Bean
    public TicketSeller getDefaultTicketSeller() {
        return new TicketSeller(
                new TicketOffice(OFFICE_AMOUNT, new Ticket(TICKET_FEE))
        );
    }
}
