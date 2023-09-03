package com.wanted.preonboarding.cafe.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CafeOpen {
    @Bean
    public Cafe wantedCodingCafeOpen() {
        String name = "wantedCodingCafe";
        Long amount = 10000L;

        return Cafe.builder()
                .name(name)
                .sales(amount)
                .barista(new Barista(Rank.BEGINNER, Status.WAITING))
                .cashier(new Cashier())
                .build();
    }
}
