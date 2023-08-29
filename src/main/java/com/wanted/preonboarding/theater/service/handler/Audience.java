package com.wanted.preonboarding.theater.service.handler;


import lombok.Getter;

@Getter
public class Audience {
    private final Bag bag;


    public Audience(Bag bag){
        this.bag = bag;
    }
    //티켓구매와 초대장 확인은 가방이 구매하는게 아니라 관객이 하는것이라서, 관객도메인에서 실행시켜주기
    public boolean hasInvitation(){
        return this.bag.hasInvitation();
    }

    public void buyTicket(Long price){
        this.bag.minusAmount(price);
    }

    public void updateTicket(Ticket ticket) {
        this.bag.setTicket(ticket);
    }

}
