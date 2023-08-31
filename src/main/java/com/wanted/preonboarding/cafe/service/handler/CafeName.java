package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class CafeName {
    private final String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CafeName cafeName)) return false;
        return Objects.equals(name, cafeName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
