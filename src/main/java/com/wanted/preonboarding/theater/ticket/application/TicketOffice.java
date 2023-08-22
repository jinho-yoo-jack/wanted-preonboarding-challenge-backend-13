package com.wanted.preonboarding.theater.ticket.application;

import com.wanted.preonboarding.theater.ticket.domain.Ticket;
import com.wanted.preonboarding.theater.ticket.domain.TicketRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketOffice {
    private static final String TICKET_NOT_FOUND = "티켓이 존재하지 않습니다.";
    private static final Long TICKET_OFFICE_INIT_MONEY = 20000L;
    private final TicketRepository ticketRepository;

    private volatile long amount;

    @PostConstruct
    public void init() {
        this.amount = TICKET_OFFICE_INIT_MONEY;
    }

    public Ticket getTicket(long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(TICKET_NOT_FOUND));
    }

    public synchronized void plusAmount(long amount) {
        this.amount += amount;
    }
}
