package com.wanted.preonboarding.theater.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotAllowedAudienceException extends RuntimeException{
    private HttpStatus status;
    private String errMessage;
}
