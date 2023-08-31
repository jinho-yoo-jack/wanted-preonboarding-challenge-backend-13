package com.wanted.preonboarding.theater.service.handler;

import java.util.Arrays;
import java.util.List;

public class TicketOffice {

    /** office가 가지고 있는 돈 */
    private long amount;

    /** 티켓 */
    private final List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }


    /** 티켓을 줌 */
    public Ticket getTicket(){
        return tickets.get(0);
    }

    /** 돈을 차감함 */
    public void minusAmount(long amount) {
        this.amount -= amount;
    }

    /** 돈을 추가함 */
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
