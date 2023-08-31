package com.wanted.preonboarding.domain.theater.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Ticket {

  private Long fee;

  public Ticket(Long fee) {
    this.fee = fee;
  }

  public Long getFee() {
    return fee;
  }
}
