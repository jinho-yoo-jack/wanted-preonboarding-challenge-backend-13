package com.wanted.preonboarding.theater.service.handler;

import java.util.Arrays;
import java.util.List;


/**
 * 리펙토링한 부분:
 *                  - plusAmount()는 private으로 함.
 *                    대신 티켓구매 발생 시 amount를 증가하는 로직 호출은 increateAmountWithFee()을 따로 만들고 public으로 함. (은닉화)
 *
 */
public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }


    public void increaseAmountWithFee(long fee) {
        plusAmount(fee);
    }

    public Ticket getTicket(){
        return tickets.get(0);
    }

    private void minusAmount(long amount) {
        this.amount -= amount;
    }
    private void plusAmount(long amount) {
        this.amount += amount;
    }
}
