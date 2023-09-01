package com.wanted.preonboarding.cafe.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

import static com.wanted.preonboarding.cafe.domain.ValidateMessage.*;

@Getter
@AllArgsConstructor
public class Order {
    @NotNull(message = INVALID_MENU)
    private Menu menu;

    @Min(value = 1, message = INVALID_ORDER_SIZE)
    private int count;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return count == order.count && menu == order.menu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu, count);
    }
}
