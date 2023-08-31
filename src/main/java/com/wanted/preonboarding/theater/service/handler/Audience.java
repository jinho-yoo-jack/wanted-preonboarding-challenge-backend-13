package com.wanted.preonboarding.theater.service.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 관객 클래스
 *
 * 관객은 가방을 가지고 있음
 */
public class Audience {

    /** 관객의 가방 */
    private final Bag bag;

    public Audience(Bag bag){
        this.bag = bag;
    }

    /** 티켓이 있는지 확인 */
    public boolean hasTicket() {
        return this.bag.hasTicket();
    }

    /** 초대권이 있는지 확인 */
    public boolean hasInvitation() {
        return this.bag.hasInvitation();
    }
    public Invitation getInvitation() {
        return this.bag.getInvitation();
    }

    /** 티켓을 저장 */
    public void setTicket(Ticket ticket) {
        this.bag.setTicket(ticket);
    }
    /** 돈을 차감 */
    public Long minusAmount(long amount) {
        return this.bag.minusAmount(amount);
    }

    /** 돈을 확인 */
    public Long getAmount() {
        return this.bag.getAmount();
    }
}