package com.wanted.preonboarding.domain.theater.entity;

import org.springframework.stereotype.Component;

@Component
public class Audience {

  private final Bag bag;

  public Audience(Bag bag) {
    this.bag = bag;
  }

  public Bag getBag() {
    return bag;
  }

}