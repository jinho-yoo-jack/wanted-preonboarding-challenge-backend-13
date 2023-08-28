package com.wanted.preonboarding.theater.service.handler;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }


    /**
     * ticket의 가격을 반환
     * 1. 초대장이 있다면 티켓과 교환하므로 비용이 들지 않는다. -> 0L return
     * 2. 초대장이 없다면 티켓을 구매해야한다. -> ticket 가격 return
     */
    public Long buyTicket(Ticket ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        } else {
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

}