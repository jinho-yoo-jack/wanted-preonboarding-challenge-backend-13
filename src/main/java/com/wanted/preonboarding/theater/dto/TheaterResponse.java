package com.wanted.preonboarding.theater.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class TheaterResponse {

  @Data
  @AllArgsConstructor
  public static class Enter {
    private boolean isTicketBought;

    public static Enter isTicketBought(boolean isTicketBought) {
      return new Enter(isTicketBought);
    }
  }
}
