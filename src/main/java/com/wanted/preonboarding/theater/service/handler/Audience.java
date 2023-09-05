package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Audience {

    private final Bag bag;

    public long buy(Ticket ticket) {
        log.info("Before audience buy ticket, bag amount: {}, ticket status: {}", bag.getAmount(), bag.hasTicket());
        bag.hold(ticket);
        log.info("Audience buy ticket, ticket fee: {}, bag amount: {}, ticket status: {}", ticket.getFee(), bag.getAmount(), bag.hasTicket());
        return bag.hasInvitation() ? 0L : ticket.getFee();
    }

}