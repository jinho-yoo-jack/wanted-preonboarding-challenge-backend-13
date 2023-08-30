package com.wanted.preonboarding.cafe.dto;

import com.wanted.preonboarding.cafe.entity.BeverageType;
import com.wanted.preonboarding.cafe.entity.OrderItem;
import com.wanted.preonboarding.cafe.exception.MenuOrderException;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class OrderMenuItemDTO {
    @NonNull
    private String menuName;
    @NonNull
    private Integer amount;

    public OrderItem orderMenuItemDTOToMenuItem() throws MenuOrderException {
        BeverageType beverageTypeByInputName = BeverageType.getBeverageTypeByInputName(this.menuName);
        return OrderItem.builder()
                .name(beverageTypeByInputName.name())
                .amount(amount)
                .build();
    }
}
