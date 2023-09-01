package com.wanted.preonboarding.cafe.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Customer;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;
    
    
    public long order(HashMap<String, Integer> orders){
        long totalPrice = wantedCafe.getCashier().calculateTotalPrice(orders);
        return totalPrice;
    }
    
    @Transactional
    public String payment(Customer customer) {
    	String result = "";
    	
    	try {
    		//결제와 관련된 도메인에 연결하여 요청하는 로직을 추가해야함
        	
        	wantedCafe.plusSales(customer.getTotalPrice());
        	
        	//주문번호를 결과로 
        	result = wantedCafe.getBarista().makeOrder(customer.getMyOrders());
		} catch (Exception e) {
			// 예외 추가
		}
    	
    	return result;
    }
    
    //주문지 만드는 메소드
    public String getOrderToBarista(String orderNo) {
    	Map<String, Integer> order = wantedCafe.getBarista().getOrder(orderNo);
    	String orderPaper = wantedCafe.getBarista().makeCoffeeTo(order);
    	return orderPaper;
    }
    
    //주문 완성 및 알림 (주문내역을 따로 저장하는 것은 DB일때 구현)
    public void completeOrder(String orderNo) {
    	wantedCafe.getBarista().completeOrder(orderNo);
    }

}
