package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.Client.RequestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {
    private TicketOffice office;

    public boolean enter(RequestMessage message){
        this.office = message.getTicketOffice();
        Audience audience = message.getAudience();

        if(audience.hasInvitation()) { // 초대권을 가지고 있으면
            return true;
        }

        if(audience.hasTicket()) { // 예매권을 가지고 있으면
            return true;
        }

        Ticket ticket = office.getTicket();
        Long bill = ticket.getFee();
        // 예매권이 없는데 금액이 더 넘는다면
        if(audience.minusMoney(bill)) {
            audience.setPass(ticket); // bill 금액을 차감한 대가로 ticket을 얻는다.
            office.plusMoney(bill); // office는 audience의 ticket을 준 대가로 bill을 번다.
            return true;
        }
        // 예매권도 없는데 금액도 부족하다면
        return false;
    }
}
