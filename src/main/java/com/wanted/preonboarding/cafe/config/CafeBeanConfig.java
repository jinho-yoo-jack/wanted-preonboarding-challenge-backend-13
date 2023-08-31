package com.wanted.preonboarding.cafe.config;

import com.wanted.preonboarding.cafe.service.handler.Barista;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

@Configuration
public class CafeBeanConfig {
    private static final String CAFE_NAME = "wantedCodingCafe";
    private static final long CAFE_SALES = 10000L;
    private static final Map<String, Integer> CAFE_MENU = Map.of(
            "AMERICANO", 100,
            "LATTE", 200,
            "MOCHA", 300
    );
    private static final LinkedBlockingDeque<Barista> CAFE_BARISTAS = new LinkedBlockingDeque<>(List.of(
            new Barista(0, 0),
            new Barista(1, 0),
            new Barista(2, 0)
    ));

    /**
     * Cafe Bean을 생성하는 메소드
     * @return Cafe Bean
     */
    @Bean
    public Cafe getDefaultCafe() {
        return new Cafe(CAFE_NAME, CAFE_SALES, CAFE_MENU, CAFE_BARISTAS);
    }
}
