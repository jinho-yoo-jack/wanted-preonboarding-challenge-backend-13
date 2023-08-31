package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CafeService {

    private final Cafe wantedCafe;

    private static final Long AMERICANO_PRICE = 100L;
    private static final Long CAFELATTE_PRICE = 200L;
    private static final Long ICETEA_PRICE = 50L;

    /**
     * 고객 주문
     * @param orders
     * @return
     */
    public String orderFrom(Orders orders){
        log.info("CafeService.orderFrom: {}", orders);

        Customer customer = Customer.builder()
                    .paymentMethod(orders.getPaymentMethod())
                    .myOrders(orders.getMenuMap())
                .build();

        return buyCoffee(customer);
    }

    /**
     * 커피 결제
     * @param customer
     * @return
     */
    private String buyCoffee( Customer customer) {
        log.info("CafeService.buyCoffee: {}", customer);

        // 메뉴 검증
        Map<String, Integer> orders = validateMenu(customer.getMyOrders());
        
        // 총 주문 금액
        final Long totalPrice = calculateTotalPrice(orders);
        
        return takeOrder(orders, totalPrice);
    }

    /**
     * 메뉴 확인
     * @param myOrders
     * @return
     */
    private Map<String, Integer> validateMenu(Map<String, Integer> myOrders) {
        log.info("CafeService.validateMenu");

        Map<String, Integer> validatedOrders = new HashMap<>();
        for (String key : myOrders.keySet()) {
            if ("AMERICANO".equalsIgnoreCase(key)
                    || "CAFELATTE".equalsIgnoreCase(key)
                    || "ICETEA".equalsIgnoreCase(key) ) {
                validatedOrders.put(key, myOrders.get(key));
                continue;
            }
            log.info("We don't have {}." , key);
        }
        return validatedOrders;
    }

    /**
     * 전체 금액 계산
     * @param orders
     * @return
     */
    private Long calculateTotalPrice(Map<String, Integer> orders) {
        log.info("CafeService.calculateTotalPrice");

        Long totalPrice = 0L;
        for (String key : orders.keySet()) {
            switch(key) {
                case "AMERICANO":
                    totalPrice += AMERICANO_PRICE * orders.get(key);
                    break;
                case "CAFELATTE":
                    totalPrice += CAFELATTE_PRICE * orders.get(key);
                    break;
                case "ICETEA":
                    totalPrice += ICETEA_PRICE * orders.get(key);
                    break;
            }
        }
        return totalPrice;
    }

    /**
     * 주문 접수
     * @param receivedOrders
     * @param totalPrice
     * @return
     */
    private String takeOrder(Map<String, Integer> receivedOrders, long totalPrice) {
        log.info("CafeService.takeOrder");

        plusSales(totalPrice);
        return makeCoffeeTo(receivedOrders);
    }

    /**
     * 커피 제조
     * @param orders
     * @return
     */
    private String makeCoffeeTo(Map<String, Integer> orders){
        log.info("CafeService.makeCoffeeTo");

        StringBuilder makeOrders = new StringBuilder();
        for(String coffeeName : orders.keySet()){
            int quantity = orders.get(coffeeName);
            makeOrders.append(coffeeName)
                    .append(":")
                    .append(quantity)
                    .append("\n");
        }
        return makeOrders.toString();
    }

    /**
     * 총 매출 금액 증가 (판매)
     * @param amount
     */
    private void plusSales(Long amount){
        wantedCafe.builder()
                .sales(wantedCafe.getSales() + amount)
                .build();
    }

    /**
     * 총 매출 금액 감소 (환불)
     * @param amount
     */
    private void minusSales(Long amount){
        wantedCafe.builder()
                .sales(wantedCafe.getSales() - amount)
                .build();
    }
}
