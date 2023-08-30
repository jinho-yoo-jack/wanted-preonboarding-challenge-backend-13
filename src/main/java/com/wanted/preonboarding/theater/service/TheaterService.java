package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class TheaterService {

    // TicketSeller와 TicketOffice의 성격을 고려할 때, 사용자의 요청에 따라
    // 생성하기 보다는 server에서 관리하는 게 옳다 생각했습니다.
    private HashMap<String, TicketSeller> ticketSellers = null;
    private boolean initialized = false;
    private void initialize() {
        this.ticketSellers = new HashMap<>();
        this.ticketSellers.put("default", new TicketSeller(new TicketOffice(200000L, new Ticket(100L))));
        initialized = true;
    }

    public String enter(long audienceAmount) {
        return enter(audienceAmount, "default");
    }
    public String enter(long audienceAmount, String ticketSellerName) {
        // Theater는 용도가 불분명하여 삭제했습니다.
        if (!initialized) initialize();
        Audience audience = new Audience(new Bag(audienceAmount));
        TicketSeller ticketSeller = ticketSellers.get(ticketSellerName);
        Ticket ticket = ticketSeller.getTicketOffice().getTicket();

        if (!audience.getBag().hasInvitation()) {
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
        }
        audience.getBag().setTicket(ticket);

        return "Have a good time.";
    }



}
