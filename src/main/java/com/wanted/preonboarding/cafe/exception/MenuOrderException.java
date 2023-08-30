package com.wanted.preonboarding.cafe.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuOrderException extends RuntimeException{
    private HttpStatus status;
    private String errMessage;
}
