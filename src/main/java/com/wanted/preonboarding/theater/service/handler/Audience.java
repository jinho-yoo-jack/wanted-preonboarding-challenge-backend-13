package com.wanted.preonboarding.theater.service.handler;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    public boolean hasInvitation() {
        return this.bag.getInvitation() != null;
    }

    public long receiveTicket(Ticket ticket) {
        long fee = 0;
        if (!this.hasInvitation()) {
            log.info("초대권이 없으므로 초대권을 삽니다.");
            this.bag.minusAmount(ticket.getFee());
            fee = ticket.getFee();
        }

        this.bag.setTicket(ticket);
        return fee;
    }
}