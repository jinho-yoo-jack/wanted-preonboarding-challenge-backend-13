package com.wanted.preonboarding.theater.service.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Invitation {
    private LocalDateTime when;

    public Invitation(){
    }

    public Invitation(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        when = LocalDateTime.parse(str, formatter);
    }
}
