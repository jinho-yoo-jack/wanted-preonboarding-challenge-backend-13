package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Theater {

    private final List<EntryStrategy> entryStrategies;

    public void enter(Audience audience, TicketSeller ticketSeller){

        EntryStrategy entryStrategy = entryStrategies.stream()
                .filter(es -> es.isTargetAudience(audience.getState()))
                .findAny()
                .orElseThrow(RuntimeException::new);

        entryStrategy.enter(audience, ticketSeller);
    }
}
