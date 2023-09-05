package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class Cashier {
    private static final Cafe cafe = new Cafe();
    private static final OrderBook orderBook  = new OrderBook();

    public UUID takeOrder(Map<Beverage, Integer> receivedOrders) {
        UUID newOrderId = createOrderId();
        orderBook.add(newOrderId, new Order(receivedOrders));

        return newOrderId;
    }

    public String sendOrder(Barista toBarista, UUID withOrderId){
        return toBarista.makeBeverageTo(withOrderId, orderBook.getOrder(withOrderId));
    }

    public String completeOrder(UUID u, String message){
        orderBook.remove(u);
        return message;
    }

    public long calculateTotalPrice(Map<Beverage, Integer> receivedOrders) {
        AtomicLong totalPrice = new AtomicLong(0L);
        receivedOrders.forEach(((beverage, quantity) -> {
            totalPrice.addAndGet((long) beverage.calculatePrice() * quantity);
        }));

        return totalPrice.get();
    }

    private UUID createOrderId(){
        return UUID.randomUUID();
    }

}
