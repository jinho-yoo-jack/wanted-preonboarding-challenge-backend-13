package com.wanted.preonboarding.theater.ticket.domain;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TicketRepository {
    private final ConcurrentHashMap<Long, Ticket> tickets = new ConcurrentHashMap<>();
    private volatile long idSequence = 0L;

    public synchronized void save(Ticket ticket) {
        if (ticket.getId() < 1) {
            idSequence++;
            ticket.setId(idSequence);
        }
        tickets.put(idSequence, ticket);
    }

    public Optional<Ticket> findById(long id) {
        return Optional.of(tickets.get(id));
    }

    public List<Ticket> findAll() {
        return tickets.values().stream().toList();
    }
}
