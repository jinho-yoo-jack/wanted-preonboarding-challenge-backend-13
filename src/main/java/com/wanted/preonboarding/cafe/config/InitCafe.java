package com.wanted.preonboarding.cafe.config;

import com.wanted.preonboarding.cafe.domain.Barista;
import com.wanted.preonboarding.cafe.domain.BaristaRank;
import com.wanted.preonboarding.cafe.domain.BaritaStauts;
import com.wanted.preonboarding.cafe.domain.Cafe;
import com.wanted.preonboarding.cafe.domain.Cashier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitCafe {

    @Bean
    public Cafe makeCafe() {
        Barista barista = new Barista(BaristaRank.MIDDLE, BaritaStauts.WAITING);
        Cashier cashier = new Cashier();
        return new Cafe(cashier, barista);
    }
}
