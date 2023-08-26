package com.wanted.preonboarding.theater.service.handler;

import java.util.Arrays;
import java.util.List;

// amount -> sales 의미 구체화
public class TicketOffice {
    private long sales;
    private final List<Ticket> tickets;

    public TicketOffice(Long sales, Ticket ... tickets) {
        this.sales = sales;
        this.tickets = Arrays.asList(tickets);
    }

    public Ticket getTicket(){
        // 여러 개의 티켓 중 하나를 가져오는 방법
        // 좀 더 확장성을 고려한다면 람다를 받아서 처리?
        return tickets.get(0);
    }

    public void minusSales(long sales) {
        this.sales -= sales;
    }
    public void plusSales(long sales) {
        this.sales += sales;
    }
}
