package com.wanted.preonboarding.theater.service.handler;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;

    @Builder
    public Bag(Long amount, Invitation invitation, Ticket ticket) {
        this.amount = amount;
        this.invitation = invitation;
        this.ticket = ticket;
    }

    public static Bag of(long amount, LocalDateTime invitationAt) {
        return Bag.builder()
                .amount(amount)
                .invitation(invitationAt != null ? new Invitation(invitationAt) : null)
                .build();
    }

    public boolean hasInvitation() {
        return invitation != null;
    }
    public boolean hasTicket() {
        return ticket != null;
    }
    public void registerTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }

    public long buy(Ticket ticket) {
        if (hasInvitation()) {
            registerTicket(ticket);
            return 0L;
        }
        minusAmount(ticket.getFee());
        registerTicket(ticket);
        return ticket.getFee();
    }
}
