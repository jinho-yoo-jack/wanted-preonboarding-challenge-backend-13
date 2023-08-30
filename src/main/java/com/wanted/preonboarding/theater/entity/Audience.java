package com.wanted.preonboarding.theater.entity;

import lombok.Getter;

@Getter
public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){ return bag;}
}