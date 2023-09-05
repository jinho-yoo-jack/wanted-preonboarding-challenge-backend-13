package com.wanted.preonboarding.cafe;

import com.wanted.preonboarding.cafe.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class CafeConfig {

    @Bean
    public Cafe wantedCafe() {
        WantedCafe wantedCafe = new WantedCafe("WantedCafe", 10000L, new ArrayList<>(), new ArrayList<>());
        List<Cashier> cashiers = wantedCafe.createCashiers(2);
        cashiers.forEach(wantedCafe::addCashier);
        List<Barista> baristas = wantedCafe.createBaristas(3);
        baristas.forEach(wantedCafe::addBarista);

        return wantedCafe;
    }
}
