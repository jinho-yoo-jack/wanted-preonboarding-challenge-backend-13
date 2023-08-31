package com.wanted.preonboarding.cafe.service.handler;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Cafe {
    @Getter private final String name;
    @Getter private final Barista baristaBeginner;
    @Getter private final Barista baristaMiddle;
    @Getter private final Barista baristaMaster;
    @Getter private final Cashier cashier;

    public Cafe(){
        this.name = "wantedCodingCafe";
        this.baristaBeginner = new Barista(0,0);
        this.baristaMiddle = new Barista(1,0);
        this.baristaMaster = new Barista(2,0);
        this.cashier = new Cashier();
    }

    public boolean canMakeCoffee(int baristaRank) {
        log.error("주문 확인하는 바리스타 rank [{}]", baristaRank);
        if (baristaRank == 0) {
            return baristaBeginner.canMakeCoffee();
        }
        if (baristaRank == 1) {
            return baristaMiddle.canMakeCoffee();
        }
        if (baristaRank == 2) {
            return baristaMaster.canMakeCoffee();
        }
        return false;
    }

    public void plusSales(Long amount){
        cashier.plusSales(amount);
    }
    public void minusSales(Long amount){
        cashier.minusSales(amount);
    }


    /**
     * 커피 만들기
     * @param orderRequest
     * @return
     */
    public String makeCoffee(OrderRequest orderRequest) {
        int baristaRank = orderRequest.getBaristaRank();
        if (baristaRank == 0) {
            return baristaBeginner.makeCoffeeTo(orderRequest);
        }
        if (baristaRank == 1) {
            return baristaMiddle.makeCoffeeTo(orderRequest);
        }
        if (baristaRank == 2) {
            return baristaMaster.makeCoffeeTo(orderRequest);
        }
        return "커피 못만듬";
    }
}
