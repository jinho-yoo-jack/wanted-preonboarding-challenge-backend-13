package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.dto.RequestMessage;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Audience(RequestMessage requestMessage) {
        this.bag = new Bag(requestMessage.getInvitation(), requestMessage.getAmount());
    }

    public Bag getBag() {
        return bag;
    }
}