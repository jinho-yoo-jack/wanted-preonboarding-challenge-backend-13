package com.wanted.preonboarding.theater.service.handler;

public record AudienceDto(String name, Bag bag) {

    public Audience toEntity() {
        return new Audience(name, bag);
    }
}
