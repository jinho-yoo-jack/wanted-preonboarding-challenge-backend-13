package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.service.handler.Menu;
import lombok.Data;
import lombok.Getter;

import java.util.HashMap;

@Data
public class OrderRequest {
    private HashMap<String,Integer> menuList;
    private String paymentMethod;
}
