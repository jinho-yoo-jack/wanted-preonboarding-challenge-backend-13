package com.wanted.preonboarding.cafe.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.BlockingDeque;

@Component
@RequiredArgsConstructor
public class Cashier {
    private final Cafe cafe;

    /**
     * 주문을 받아서 처리하는 메소드
     * @param receivedOrders 주문
     * @param customer 고객 정보
     * @return 주문 결과 영수증
     */
    public String takeOrder(Map<String, Integer> receivedOrders, Customer customer) throws InterruptedException {
        long totalPrice = calculateTotalPrice(receivedOrders);
        cafe.plusSales(totalPrice);
        return sendTo(receivedOrders) +
                "\n" +
                "Payment: " + customer.getPaymentMethod() +
                "\n" +
                "Total Price: " + totalPrice;
    }

    /**
     * 주문을 바리스타에게 전달하고 결과를 반환 받는 메소드
     * @param receivedOrders 주문
     * @return 주문 결과
     */
    private String sendTo(Map<String, Integer> receivedOrders) throws InterruptedException {
        BlockingDeque<Barista> baristas = cafe.getBaristas();

        Barista barista = baristas.take();
        String result = barista.makeCoffeeTo(receivedOrders);
        baristas.add(barista);

        return result;
    }

    /**
     * 주문에 대한 총 가격을 계산하는 메소드
     * @param orders 주문
     * @return 총 가격
     */
    private long calculateTotalPrice(Map<String, Integer> orders) {
        long totalPrice = 0L;
        for (String menu : orders.keySet()) {
            totalPrice += (long) cafe.getMenu().get(menu) * orders.get(menu);
        }
        return totalPrice;
    }
}
