package com.wanted.preonboarding.domain.theater.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

  public boolean enter(Audience audience, TicketSeller ticketSeller) {
    Bag bag = audience.getBag();
    if (bag.hasInvitation() || bag.hasTicket()) {
      return true;
    }
    Long ticketFee = ticketSeller.getTicketFee();
    if (bag.getAmount() >= ticketFee) {
      bag.minusAmount(ticketFee);
      ticketSeller.sellTicket(ticketFee);
      return true;
    }
    return false;
  }
}
