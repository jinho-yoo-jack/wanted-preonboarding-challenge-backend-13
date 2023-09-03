package com.wanted.preonboarding.theater.domain;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public boolean hasTicket() {
        return bag.hasTicket();
    }

    public boolean hasInvitation() {
        return bag.hasInvitation();
    }

    public void changeTicket(Ticket ticket) {
        bag.changeTicket(ticket);
    }

    public Long myMoney() {
        return bag.inMoney();
    }

    public void buyTiket(Ticket ticket) {
        bag.buyTiket(ticket);
    }

}