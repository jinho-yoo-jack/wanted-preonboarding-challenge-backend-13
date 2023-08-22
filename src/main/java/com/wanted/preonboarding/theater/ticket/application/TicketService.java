package com.wanted.preonboarding.theater.ticket.application;

import com.wanted.preonboarding.theater.ticket.domain.Ticket;
import com.wanted.preonboarding.theater.ticket.domain.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private static final String TICKET_NOT_FOUND = "티켓을 찾을 수 없습니다";
    private final TicketRepository ticketRepository;

    @Transactional
    public void add(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public Ticket findById(long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(TICKET_NOT_FOUND));
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }
}
