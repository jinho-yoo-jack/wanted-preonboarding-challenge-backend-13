package com.wanted.preonboarding.theater.service.handler;

/**
 * 리펙토링한 부분:
 *                  - putTicket()만 public으로 선언하고 getTicket()...은 private로 선언함으로써 변수를 은닉화 함.
 *                  - minusAmount()에서 amount가 음수가 나올경우 Exception을 던짐
 *                      외부에서 putTicket()을 사용했을 때 비즈니스 로직과 예외 처리 로직을 분리할 수 있음
 *                      if - else로 처리하면 비즈니스 로직과 예외처리 로직이 같이 있게됨
 */

public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;

    public Bag(long amount){
        this(null, amount);
    }
    public Bag(Invitation invitation, long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

    public long putTicket(Ticket ticket) throws Exception { // hold보단 티켓을 담는 함수이기 때문에 putTicket로 이름을 지음
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    private boolean hasInvitation() {
        return invitation != null;
    }
    private boolean hasTicket() {
        return ticket != null;
    }
    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    private void minusAmount(long amount) throws Exception {
        if (amount<0) throw new Exception();
        else this.amount -= amount;
    }
    private long getAmount() {return this.amount;}
    private void plusAmount(long amount) {
        this.amount += amount;
    }

}
