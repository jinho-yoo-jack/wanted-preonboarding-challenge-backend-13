package com.wanted.preonboarding.domain.theater.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Getter
public class Bag {

  private Long amount;
  private final Invitation invitation;
  private Ticket ticket;

  public Bag(long amount) {
    this(null, amount);
  }


  public Bag(Invitation invitation, Long amount) {
    this.invitation = invitation;
    this.amount = amount;
  }

  public Bag(Invitation invitation, Long amount, Ticket ticket) {
    this.invitation = invitation;
    this.amount = amount;
    this.ticket = ticket;
  }

  public Bag(Long amount, Ticket ticket) {
    this.amount = amount;
    this.ticket = ticket;
    this.invitation = null;
  }

  public boolean hasInvitation() {
    return invitation != null;
  }

  public boolean hasTicket() {
    return ticket != null;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public void minusAmount(long amount) {
    this.amount -= amount;
  }

  public void plusAmount(long amount) {
    this.amount += amount;
  }
}
