package com.wanted.preonboarding.theater.service.handler;

import java.time.LocalDateTime;
import java.util.Objects;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public static Audience of(long amount, LocalDateTime invitedAt) {
        if (Objects.isNull(invitedAt)) {
            return new Audience(new Bag(amount));
        }
        return new Audience(new Bag(new Invitation(invitedAt), amount));
    }

    public long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}
