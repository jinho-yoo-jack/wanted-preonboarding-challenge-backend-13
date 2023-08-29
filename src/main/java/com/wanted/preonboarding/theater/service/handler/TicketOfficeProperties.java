package com.wanted.preonboarding.theater.service.handler;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ticket.office")
public class TicketOfficeProperties {
    private long amount;

    public void setAmount(String fee) {
        this.amount = Long.parseLong(fee);
    }

    public long getAmount() {
        return amount;
    }
}
