package com.wanted.preonboarding.cafe.service.handler;

import jakarta.annotation.PostConstruct;
import lombok.*;
import org.springframework.stereotype.Component;
@Builder
@Getter
@AllArgsConstructor
@Component
public class Cafe {
    private final String name;
    private Long sales;

    public Cafe(){
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
    }

}
