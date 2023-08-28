package com.wanted.preonboarding.theater.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class enterRequest {
    Long amount;
    LocalDateTime invitationCode;
}
