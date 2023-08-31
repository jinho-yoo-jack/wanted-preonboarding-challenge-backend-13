package com.wanted.preonboarding.cafe;

import com.wanted.preonboarding.cafe.service.handler.Barista;
import com.wanted.preonboarding.cafe.service.handler.CafeName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CafeConfig {

    @Bean
    public CafeName wantedCafe() {
        return new CafeName("wanted cafe");
    }

    @Bean
    public Long cafeSales() {
        return 0L;
    }

    @Bean
    public Barista barista() {
        return new Barista(0, 0);
    }
}
