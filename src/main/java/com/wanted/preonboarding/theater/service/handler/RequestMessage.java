package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class RequestMessage {

    private Long audience_amount ;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate time;

}
