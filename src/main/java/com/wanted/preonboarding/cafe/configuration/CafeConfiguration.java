package com.wanted.preonboarding.cafe.configuration;

import com.wanted.preonboarding.cafe.service.handler.Barista;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CafeConfiguration {

    @Bean
    public Cafe cafe() {
        return new Cafe("wantedCate", 10000L, new Cashier(), new Barista(0, 0));
    }

}
