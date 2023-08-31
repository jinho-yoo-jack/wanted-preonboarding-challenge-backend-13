package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.configuration.MenuProperties;
import com.wanted.preonboarding.cafe.exception.NotSupportedMenuItem;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Menu {
    private static final List<MenuItem> items = new ArrayList<>();
    private final MenuProperties menuProperties;

    @Autowired
    public Menu(MenuProperties menuProperties) {
        this.menuProperties = menuProperties;
    }

    @PostConstruct
    public void initializeItems() {
        items.clear();
        for (MenuProperties.MenuItemInfo menuItemInfo : menuProperties.getItems()) {
            MenuItem menuItem = new MenuItem(menuItemInfo.getName(), menuItemInfo.getPrice());
            items.add(menuItem);
        }
    }

    public static Map<MenuItem, Integer> createMenuItemMap(Map<String, Integer> orders) {
        return orders.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> choose(entry.getKey()),
                        Map.Entry::getValue
                ));
    }

    public static MenuItem choose(String name) {
        for(MenuItem each : items) {
            if (each.getName().equals(name)) {
                return each;
            }
        }
        throw new NotSupportedMenuItem(name);
    }
}
