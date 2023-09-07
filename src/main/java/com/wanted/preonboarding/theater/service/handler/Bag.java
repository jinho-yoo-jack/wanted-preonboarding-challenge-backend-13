package com.wanted.preonboarding.theater.service.handler;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Bag {
    
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;
    
    @Builder
    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }
    
    /**
     * 티켓 구매 메서드
     *
     * @param ticket 구매할 티켓
     * @return 구매한 티켓의 가격
     */
    public long buy(Ticket ticket) {
        
        if (hasInvitation()) {
            registerTicket(ticket);
            return 0L;
        } else {
            registerTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
    
    /**
     * 초대장이 있는지 확인
     *
     * @return true/false
     */
    public boolean hasInvitation() {
        return invitation != null;
    }
    
    /**
     * 티켓이 있는지 확인
     *
     * @return true/false
     */
    public boolean hasTicket() {
        return ticket != null;
    }
    
    /**
     * 티켓 등록
     */
    public void registerTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    
    /**
     * 금액 차감
     *
     * @param amount 차감할 금액
     */
    public void minusAmount(long amount) {
        if (this.amount < amount) {
            throw new IllegalArgumentException("잔액 부족");
        }
        this.amount -= amount;
    }
    
    /**
     * 금액 증가
     *
     * @param amount 증가할 금액
     */
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
