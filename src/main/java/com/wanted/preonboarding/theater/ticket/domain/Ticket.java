package com.wanted.preonboarding.theater.ticket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;


public class Ticket {

    private long id;
    private Long fee;


    public Ticket(Long fee) {
        this.fee = fee;
    }

    public Ticket() {
        this.fee = 0L;
    }

    public long getId() {
        return this.id;
    }

    public Long getFee() {
        return fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return getId() == ticket.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public void setId(long id) {
        this.id = id;
    }
}
