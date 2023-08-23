package com.wanted.preonboarding.cafe;

import com.wanted.preonboarding.cafe.service.handler.Barista;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.WantedCafe;
import com.wanted.preonboarding.theater.service.handler.Ticket;
import com.wanted.preonboarding.theater.service.handler.TicketOffice;
import com.wanted.preonboarding.theater.service.handler.TicketSeller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CafeConfig {

    @Bean
    public Cafe cafe() {
        WantedCafe wantedCafe = new WantedCafe("WantedCafe", 10000L, new ArrayList<>(), new ArrayList<>());
        wantedCafe.addCashier(new Cashier(wantedCafe));
        wantedCafe.addBarista(new Barista(0,0));
        wantedCafe.addBarista(new Barista(1,0));
        wantedCafe.addBarista(new Barista(2,0));

        return wantedCafe;
    }

}
