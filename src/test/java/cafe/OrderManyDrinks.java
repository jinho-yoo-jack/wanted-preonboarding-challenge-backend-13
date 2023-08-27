package cafe;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Menu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class OrderManyDrinks {

    @Test
    void orderManyDrinks() {
        Map<String, Integer> orders = new HashMap<>();

        orders.put("latte", 3);
        orders.put("Americano",2);
        orders.put("mocha", 3);
        Menu menu = new Menu("card", orders);

        CafeService cafeService = new CafeService();

        System.out.println(cafeService.orderFrom(menu));
    }
}
