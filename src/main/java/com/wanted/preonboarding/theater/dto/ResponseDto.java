package com.wanted.preonboarding.theater.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private Long amount;
    private boolean invitation;
    private boolean ticket;
    private String message;
}