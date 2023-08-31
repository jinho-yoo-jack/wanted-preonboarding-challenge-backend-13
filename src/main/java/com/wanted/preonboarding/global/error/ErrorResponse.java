package com.wanted.preonboarding.global.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {

  private final String message;

  public static ErrorResponse from(String message) {
    return new ErrorResponse(message);

  }
}