package com.wanted.preonboarding.common.converter;

import com.wanted.preonboarding.cafe.enums.Menu;
import org.springframework.core.convert.converter.Converter;

public class OrderRequestConverter implements Converter<String, Menu> {

    @Override
    public Menu convert(String name) {
        return Menu.of(name);
    }
}
