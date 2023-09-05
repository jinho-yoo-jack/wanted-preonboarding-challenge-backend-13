package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface CafeService {

    public String orderFrom(CustomerDto customerDto);
}
