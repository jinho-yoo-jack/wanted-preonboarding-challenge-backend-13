package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

public class Barista {
    private int rank; // 0: Beginner 1: Middle 2: Master
    private int status; // 0: Waiting 1: Making
    
    //데이터 베이스를 써야하는 부분을 임의로 연결 (동시성문제 있을 수 있음)
    private Map<String, Map<String, Integer>> orderList = new HashMap<String, Map<String, Integer>>();
    private String orderNumber = "100";

    public Barista(int rank, int status){
        this.rank = rank;
        this.status = status;
    }

    private void setRank(int rank){
        this.rank = rank;
    }

    private void setStatus(int status){
        this.status = status;
    }
    
    public String makeOrder(Map<String, Integer> orders) {
    	//키를 String으로 하기위해
    	int orderNo = Integer.parseInt(orderNumber);
    	orderNo++;
    	orderList.put(Integer.toString(orderNo),orders);
    	return Integer.toString(orderNo);
    }
    
    //빌지 만들기
    public String makeCoffeeTo(Map<String, Integer> orders){
        StringBuilder makeOrders = new StringBuilder();
        for(String coffeeName : orders.keySet()){
            int quantity = orders.get(coffeeName);
            makeOrders.append(coffeeName)
                    .append(":")
                    .append(quantity);
        }
        return makeOrders.toString();
    }
}
