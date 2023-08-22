package com.wanted.preonboarding.theater.service.handler;

public record AudienceDto(String name, Bag bag) {

    public Audience of() {
        return new Audience(name(), bag());
    }
}
