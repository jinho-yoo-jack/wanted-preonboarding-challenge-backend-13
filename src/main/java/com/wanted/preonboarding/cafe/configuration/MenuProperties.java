package com.wanted.preonboarding.cafe.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "menu")
public class MenuProperties {
    private List<MenuItemInfo> items = new ArrayList<>();

    public List<MenuItemInfo> getItems() {
        return items;
    }

    public void setItems(List<MenuItemInfo> items) {
        this.items = items;
    }

    @Getter @Setter
    public static class MenuItemInfo {
        private String name;
        private int price;
    }
}
