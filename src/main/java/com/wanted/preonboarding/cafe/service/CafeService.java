package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Barista;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.MenuStatics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;
    private final Barista barista;
    private final MenuStatics officialMenuStatics;


    public String orderFrom(Customer customer) {
        Map<String, Long> menu = officialMenuStatics.getMenu();
        return wantedCafe.takeOrder(customer, barista, menu);
    }
}
