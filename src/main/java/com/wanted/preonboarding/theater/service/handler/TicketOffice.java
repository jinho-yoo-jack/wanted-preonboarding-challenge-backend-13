package com.wanted.preonboarding.theater.service.handler;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@Builder
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TicketOffice {
    private long amount;
    private List<Ticket> tickets;

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }

    public Ticket getTicket(){
        if (tickets == null) {
            return null;
        }
        return tickets.get(0);
    }
}
