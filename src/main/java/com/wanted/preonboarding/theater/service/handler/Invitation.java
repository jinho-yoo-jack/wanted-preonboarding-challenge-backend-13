package com.wanted.preonboarding.theater.service.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 티켓으로 교환 가능한 초대장 클래스
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Invitation {
    private LocalDateTime when;
}
