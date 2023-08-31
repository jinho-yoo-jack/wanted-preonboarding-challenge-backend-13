package com.wanted.preonboarding.domain.theater.entity;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Invitation {

  private LocalDateTime when;

  public Invitation(LocalDateTime when) {
    this.when = when;
  }
}
