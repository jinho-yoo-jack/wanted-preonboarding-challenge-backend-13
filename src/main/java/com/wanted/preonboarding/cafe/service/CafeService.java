package com.wanted.preonboarding.cafe.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;
    
    @Autowired
    public CafeService (Cashier cashier) {
    	wantedCafe = new Cafe(cashier);
    }
    
    
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
    
    

}
