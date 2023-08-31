package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class MadeCoffeeMap {
    @Getter
    Map<MenuItem, List<Coffee>> madeCoffees;

    @Setter
    Supplier<String> toStringCustomize;

    public MadeCoffeeMap(Map<MenuItem, List<Coffee>> madeCoffees) {
        this.madeCoffees = madeCoffees;
    }

    @Override
    public String toString() {
        if (toStringCustomize != null) return toStringCustomize.get();
        return "MadeCoffeeMap{" +
                "madeCoffees=" + madeCoffees +
                '}';
    }

}
