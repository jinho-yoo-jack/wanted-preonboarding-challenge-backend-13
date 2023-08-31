package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    private final HashMap<String, Item> storage = new HashMap<String, Item>();
    private boolean isNotExist(String name) {
        return !storage.containsKey(name);
    }

    private void minusStock(String name, Integer amount) throws Exception {
        if (isNotExist(name))
            throw new Exception("존재하지 않는 상품입니다.");

        Item item = storage.get(name);
        if (item.getStock() < amount)
            throw new Exception(name + "의 재고가 부족합니다. (현재 재고 : " + storage.get(name) + ")");

        item.minusStock(amount); //재고감소
        log.debug("[MINUS] {} 재고: {} -> {}", name, amount, storage.get(name).getStock());
    }

    public String order(Customer customer) throws Exception {
        log.debug("결제수단 : {}", customer.getPaymentMethod().getTitle());
        Cashier cashier = new Cashier(wantedCafe);
        // 결제
        Map<String, Integer> bill = payFor(customer.getItems());
        // 가격 합산
        final Long totalPrice = cashier.calculateTotalPrice(storage, bill);
        log.debug("결제금액 : {}", totalPrice);
        // 결제 후 음료 제조
        return cashier.takeOrder(bill, totalPrice);
    }


    public  String addStock(String name, Integer amount) throws Exception {
        if (isNotExist(name))
            throw new Exception("존재하지 않는 상품입니다.");

        Item item = storage.get(name);
        item.plusStock(amount); //재고추가

        log.debug("[ADD] {} 재고: {} -> {}", name, amount, storage.get(name).getStock());
        return name + ":" + storage.get(name);
    }

    public  String addNewItem(String name, Item item) throws Exception {
        storage.put(name, item);
        log.debug("[New] {} : {} -> {}", name, item.getPrice(), item.getStock());
        return name + "(" + item.getPrice() + "원) " + item.getStock() + "개가 재고에 추가되었습니다.";
    }

    private  Map<String, Integer> payFor(Map<String, Integer> myOrders) throws Exception {
        Map<String, Integer> result = new HashMap<>();
        Iterator<String> iter = myOrders.keySet().iterator();
        while (iter.hasNext()) {
            String name = iter.next();
            try {
                minusStock(name, myOrders.get(name));
            } catch (Exception e) { // 구매할 수 없는 경우 제외하고 가격 계산
                continue;
            }
            result.put(name, storage.get(name).getStock());
        }
        return result;
    }


}
