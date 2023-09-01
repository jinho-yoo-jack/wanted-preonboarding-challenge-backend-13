package com.wanted.preonboarding.theater.service.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Audience {

	@Autowired
	private final Bag bag;

    public Bag getBag(){ return bag;}
    
    public boolean hasTicket() {
        return bag.hasTicket();
    } 
    
    public void enterTheater(Theater theater) {
        if (hasTicket()) {
            theater.checkTicket(this);
        } else {
            theater.ticketing(this);
        }
    }
}