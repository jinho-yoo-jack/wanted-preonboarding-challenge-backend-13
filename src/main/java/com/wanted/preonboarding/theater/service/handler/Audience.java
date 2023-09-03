package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.service.AudienceRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audience {
    private final Bag bag;

    public Bag getBag(){ return bag;}

    public boolean hasTicket() {
        return bag.hasTicket();
    }

    public boolean hasInvitation() {
        return bag.hasInvitation();
    }

    public Invitation getInvitation() {
        return bag.getInvitation();
    }

    public Long getAmount() {
        return bag.getAmount();
    }

    public void minusAmount(Long fee) {
        bag.minusAmount(fee);
    }

    public void setTicket(Ticket ticket) {
        bag.setTicket(ticket);
    }

    @Builder
    public Audience(AudienceRequestDto dto) {
        bag = Bag.builder()
                .amount(dto.getAmount())
                .invitation(dto.getInvitation() == null ? null : new Invitation(
                        LocalDateTime.parse(
                                dto.getInvitation(),
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                        )
                )
                .ticket(Boolean.parseBoolean(dto.getTicket()) ? new Ticket(-1L) : null)
                .build();
    }

}