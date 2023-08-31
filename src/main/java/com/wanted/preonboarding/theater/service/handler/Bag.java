package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;
import lombok.Setter;

public class Bag {
    /** 돈 */
    @Getter private Long amount;
    /** 초대권 */
    @Getter private final Invitation invitation;
    /** 티켓 */
    @Setter private Ticket ticket;

    /** 돈만 생성 */
    public Bag(long amount){
        this(null, amount, null);
    }
    /** 초대권과 돈을 생성 */
    public Bag(Invitation invitation, long amount){
        this(invitation, amount, null);
    }
    /** 초대권과 돈을 생성 */
    public Bag(Invitation invitation, long amount,Ticket ticket){
        this.invitation = invitation;
        this.amount = amount;
        this.ticket = ticket;
    }

    /** 초대권이 있는지 확인 */
    public boolean hasInvitation() {
        return invitation != null;
    }

    /** 티켓이 있는지 확인 */
    public boolean hasTicket() {
        return ticket != null;
    }

    /** 돈을 차감 */
    public Long minusAmount(long amount) {
        Long temp = this.amount - amount;
        if (temp + amount == this.amount) {
            this.amount = temp;
            return amount;
        }
        return 0L;
    }

    /** 돈을 추가 */
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
