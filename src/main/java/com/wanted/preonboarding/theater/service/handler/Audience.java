package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;

@Getter
public class Audience {
    private final Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }
}