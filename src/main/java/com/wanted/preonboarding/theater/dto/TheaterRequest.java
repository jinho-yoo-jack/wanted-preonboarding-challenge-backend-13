package com.wanted.preonboarding.theater.dto;

import com.wanted.preonboarding.theater.service.handler.Invitation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class TheaterRequest {

  @Data
  @AllArgsConstructor
  public static class Audience {
    private Long amount;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime invitationDateTime;
  }

}
