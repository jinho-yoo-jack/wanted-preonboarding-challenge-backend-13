package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.domain.Rank;
import com.wanted.preonboarding.cafe.domain.Status;
import com.wanted.preonboarding.cafe.dto.OrderRequest;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Component
public class Cafe {
    private final String name = "wantedCodingCafe";
    private Long sales = 10000L;
    private Barista barista = new Barista(Rank.BEGINNER, Status.WAITING);
    private Cashier cashier = new Cashier();

    public String welcomeMessage() {
        return String.format("Welcome to The %s!!", name);
    }

    public void plusSales(Long amount){
        this.sales += amount;
    }

    public void minusSales(Long amount){
        this.sales -= amount;
    }

    public String orderReception(OrderRequest orderRequest) {
        plusSales(cashier.calculateTotalPrice(orderRequest.getOrder()));

        if(!barista.isBusy()) {
            return cashier.sendTo(barista, orderRequest.getOrder());
        }
        else {
            throw new IllegalStateException("barista is busy...");
        }
    }
}
