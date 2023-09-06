package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 리펙토링한 부분:
 *                  - TheaterService에서 비즈니스 로직을 구현하는 것보다 Theater객체을 만듬
 *                    이로써 theater을 다른 서비스에서도 사용할 수 있고,
 *                    Theater에 대한 비즈니스 로직이 바뀌더라도 Theater만 수정하고 다른 서비스에서는 enter()만 호출하면 되어
 *                    변경에 용이해짐.
 */

@Component
@RequiredArgsConstructor
public class Theater {

    public void enter(Audience audience, TicketSeller ticketSeller) throws Exception {
        long ticketFee = ticketSeller.sellTo(audience);
        ticketSeller.receiveFee(ticketFee);
    }
}
