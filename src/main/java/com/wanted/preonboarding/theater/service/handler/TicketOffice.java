package com.wanted.preonboarding.theater.service.handler;

import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    
    private long amount;
    private final List<Ticket> tickets;
    
    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }
    
    /**
     * 티켓 발행
     *
     * @return 발행한 티켓
     */
    public Ticket publishTicket() {
        return getTicket();
    }
    
    /**
     * 매출 증가
     *
     * @param ticketFee 판매한 티켓의 가격
     */
    public void increaseSalesAmount(long ticketFee) {
        plusAmount(ticketFee);
    }
    
    /**
     * 예산 차감
     *
     * @param amount 차감할 예산
     */
    public void minusAmount(long amount) {
        if (this.amount < amount) {
            throw new IllegalArgumentException("예산 부족");
        }
        this.amount -= amount;
    }
    
    /**
     * 예산 증가
     *
     * @param amount 증가할 예산
     */
    public void plusAmount(long amount) {
        this.amount += amount;
    }
    
    /**
     * 티켓 목록에서 티켓 조회
     *
     * @return 조회한 티켓 정보
     */
    private Ticket getTicket() {
        return tickets.get(0);
    }
}
