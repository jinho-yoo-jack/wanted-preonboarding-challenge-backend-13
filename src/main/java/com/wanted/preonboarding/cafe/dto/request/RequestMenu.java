package com.wanted.preonboarding.cafe.dto.request;

import com.wanted.preonboarding.cafe.dto.PaymentMethod;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RequestMenu {
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private List<Order> orderList;
}
