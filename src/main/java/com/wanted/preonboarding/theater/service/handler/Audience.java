package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.exception.BadRequest;
import com.wanted.preonboarding.theater.domain.RequestMessage;

public class Audience {
    private final Bag bag;

    public Audience(RequestMessage requestMessage) {
        Invitation invitation = requestMessage.getWhen() != null ? new Invitation(requestMessage.getWhen()) : null;
        long amount = requestMessage.getAmount() != null ? requestMessage.getAmount() : 0L;
        this.bag = new Bag(invitation, amount);
    }

    public Bag getBag(){
        return bag;
    }

    public boolean hasInvitation(){
        return bag.hasInvitation();
    }

    public void setTicket(Ticket ticket) {
        bag.setTicket(ticket);
    }

    public void minusAmount(Long fee) {
        try {
            bag.minusAmount(fee);
        } catch (RuntimeException e){
            throw new BadRequest("금액이 부족합니다.");
        }
    }

    public Long getAmount(){
        return bag.getAmount();
    }
}