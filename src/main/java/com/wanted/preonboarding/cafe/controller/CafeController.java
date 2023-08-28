package com.wanted.preonboarding.cafe.controller;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Customer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;
    
    @GetMapping("main")
    public String main(){
    	return "Welcome To Wanted Coding Cafe";
    }
    
    @PostMapping("order")
    public String orderFromMenu(@RequestBody HashMap<String, Integer> requestMessage, Model model){
    	//결제 전 단계를 반복할 수 있도록 분리했다.
    	long totalPrice = cafeService.order(requestMessage);
    	model.addAttribute("orders", requestMessage);
    	model.addAttribute("totalPrice", totalPrice);
        return "payment";
    }                     
    
    @GetMapping("payment")
    public String payOrder(Model model, @RequestParam String paymentMethod) {
    	//결제 정보를 받는 부분을 추가 할 수 있다.
    	String result ="";
    	try {
    		HashMap<String, Integer> orders = (HashMap<String, Integer>) model.getAttribute("orders");
    		long totalPrice = (Long)model.getAttribute("totalPrice");
    		Customer customer = new Customer(paymentMethod, orders, totalPrice);
    		result = cafeService.payment(customer);
		} catch (Exception e) {
			// 예외 추가
		}
    	return result;
    }
    @GetMapping("complete")
    public String completeOrder(Model model, @RequestParam String orderNo) {
        cafeService.completeOrder(orderNo);
    	return orderNo;
    }
}
