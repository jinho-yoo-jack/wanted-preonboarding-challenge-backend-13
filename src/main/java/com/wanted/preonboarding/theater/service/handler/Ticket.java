package com.wanted.preonboarding.theater.service.handler;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private int ticketId; // 티켓 아이디
    private String ticketName; // 티켓 이름
    private Long fee; // 티켓 가격

    // 생성자
    public Ticket(int ticketId, String ticketName, Long fee) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
        this.fee = fee;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public Long getFee() {
        return fee;
    }
}
