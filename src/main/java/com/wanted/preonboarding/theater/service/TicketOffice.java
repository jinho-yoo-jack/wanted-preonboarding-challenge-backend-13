package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.Ticket;

public interface TicketOffice {
    Ticket getTicket();
    void minusAmount(long amount);
    void plusAmount(long amount);

}
