package com.wanted.preonboarding.theater.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Builder
public class AudienceRequestDto {
    private Long money;
    private Long ticketPricePaid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime invitationCreatedAt;
}
