package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@Service
public class CafeServiceImpl implements CafeService {

    private final Cafe cafe;

    public String orderFrom(CustomerDto customerDto) {
        Customer customer = customerDto.toEntity();
        Cashier cashier = cafe.findAvailableCashier();
        return customer.getName()+"'s order [ " + cashier.takeOrder(customer) + "] complete";
    }
}
