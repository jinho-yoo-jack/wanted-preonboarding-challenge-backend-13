package com.wanted.preonboarding.theater.service.handler;

/**
 * 관람객 VO
 */
public class Audience {
    private int id; // 관람객 아이디
    private final Bag bag; // 관람객 가방

    public Audience(int id, Bag bag) {
        this.id = id;
        this.bag = bag;
    }

    public int getId() {
        return id;
    }

    public Bag getBag() {
        return bag;
    }
}