package com.wanted.preonboarding.theater.service.handler.consumer;

import com.wanted.preonboarding.theater.service.handler.seller.Ticket;
import lombok.Builder;


@Builder
public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;

    public boolean hasInvitation() {
        return invitation != null;
    }
    public boolean hasTicket() {
        return ticket != null;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public void minusAmount(long amount) {
        this.amount -= amount;
    }

    public Long getAmount() {
        return amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
