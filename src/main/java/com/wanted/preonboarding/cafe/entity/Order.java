package com.wanted.preonboarding.cafe.entity;

import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Component
public class Order implements OrderComponent {

    @Builder.Default
    private Map<OrderComponent,Integer> orderMap = new HashMap<>();

    public void addComponent(OrderComponent component, Integer amount){
        orderMap.put(component, orderMap.getOrDefault(amount,0)+1);
    }

    public Integer getAmount(OrderComponent component){
        return orderMap.get(component);
    }

    public Set<OrderComponent> getKeySet(){
        return orderMap.keySet();
    }

    @Override
    public String getName() {
        return orderMap.keySet().stream()
                .map(OrderComponent::getName)
                .collect(Collectors.joining(","));
    }

    @Override
    public Integer getAmount() {
        return orderMap.values().stream().mapToInt(Integer::intValue).sum();
    }


}
