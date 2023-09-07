package com.wanted.preonboarding.theater.dto;

import static lombok.AccessLevel.PROTECTED;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class AudienceRequestDto {
    
    private Long amount;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime invitationTime;
    
    @Builder
    public AudienceRequestDto(Long amount) {
        this.amount = amount;
        this.invitationTime = LocalDateTime.now();
    }
}
