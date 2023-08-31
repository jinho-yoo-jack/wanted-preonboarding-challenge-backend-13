package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;
import lombok.Setter;

/**
 * 관객 소지품 클래스
 */
public class Bag {
    @Getter
    private Long amount;
    private final Invitation invitation;
    @Setter
    private Ticket ticket;

    public Bag(Invitation invitation, long amount){
        this.invitation = invitation;
        this.amount = amount;
    }
    public Bag(long amount){
        this(null, amount);
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }
    public boolean hasTicket() {
        return ticket != null;
    }
}
