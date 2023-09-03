package com.wanted.preonboarding.theater.entity;

import com.wanted.preonboarding.theater.entity.Bag;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public Bag getBag(){ return bag;}
}