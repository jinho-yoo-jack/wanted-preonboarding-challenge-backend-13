package com.wanted.preonboarding.theater.service.handler;

import lombok.ToString;
import org.springframework.lang.Nullable;

@ToString(exclude = "invitation")
public class Bag {

    @Nullable
    private final Invitation invitation;
    private Long amount;
    private Ticket ticket;

    public Bag(long amount){
        this(null, amount);
    }
    public Bag(@Nullable Invitation invitation, long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

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
        if ( this.amount < 0 ) {
            throw new RuntimeException("티켓을 구매하기 위한 금액이 모자릅니다.");
        }
    }

    public Invitation getInvitation() {
        return this.invitation;
    }

    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
