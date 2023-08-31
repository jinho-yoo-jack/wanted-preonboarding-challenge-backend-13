package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.dto.request.RequestMessage;
import com.wanted.preonboarding.theater.exception.NotEnoughAmountException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Audience {
    private final Invitation invitation;
    private Ticket ticket;
    private Long amount;


    public Audience(RequestMessage requestMessage){
        this.invitation = new Invitation(requestMessage.getInvitationDate());
        this.amount = requestMessage.getAmount() == null ? 0 : requestMessage.getAmount();
    }

    public boolean hasInvitation() {
        return invitation.isValid();
    }
    public void minusAmount(long amount) throws NotEnoughAmountException {
        if(this.amount - amount < 0) {
            throw new NotEnoughAmountException("티켓을 살 돈이 부족합니다.");
        }
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return this.getTicket();
    }
}