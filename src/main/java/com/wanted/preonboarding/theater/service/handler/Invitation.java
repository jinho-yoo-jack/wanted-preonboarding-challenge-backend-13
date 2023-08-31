package com.wanted.preonboarding.theater.service.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 초대권
 */
@AllArgsConstructor
public class Invitation {
    /** 초대한 날 */
    @Getter private LocalDateTime when;

    public Invitation(String when) {
        this.when = LocalDateTime.parse(when, DateTimeFormatter.ofPattern("yyyy-MM-dd HH"));
    }
}
