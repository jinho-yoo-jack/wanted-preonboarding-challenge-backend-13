package com.wanted.preonboarding.domain.theater.entity;

import org.springframework.stereotype.Component;

@Component
public class TicketSeller {

  private final TicketOffice ticketOffice;

  public TicketSeller(TicketOffice ticketOffice) {
    this.ticketOffice = ticketOffice;
  }

  public TicketOffice getTicketOffice() {
    return ticketOffice;
  }

  public void sellTicket(long ticketFee) {
    ticketOffice.plusAmount(ticketFee);
  }

  public Long getTicketFee() {
    return ticketOffice.getTicket().getFee();
  }
}
