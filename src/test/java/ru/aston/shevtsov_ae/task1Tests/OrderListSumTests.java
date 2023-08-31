package ru.aston.shevtsov_ae.task1Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.aston.shevtsov_ae.task1.*;

public class OrderListSumTests {
    @Test
    public void calculateSumOfOrdersWithCorrectValues() {
        OrderManager orderManager = new OrderManager();
        AutoOrder autoOrder = new CreditAutoOrder(new User(12, "Pavel", "Zaharov"), 200, "CAR", 0.12D, 12);
        orderManager.addOrder(autoOrder);
        autoOrder = new CreditAutoOrder(new User(12, "Pavel", "Zaharov"), 400, "CAR", 0.12D, 24);
        orderManager.addOrder(autoOrder);
        autoOrder = new FullPriceAutoOrder(new User(12, "Pavel", "Zaharov"), 500, "CAR", true);
        orderManager.addOrder(autoOrder);
        Assertions.assertEquals(750, orderManager.calculateTotalPrice().intValue());
    }
    @Test
    public void calculateSumOfOrdersWithIncorrectValues() {
        OrderManager orderManager = new OrderManager();
        AutoOrder autoOrder = new CreditAutoOrder(new User(12, "Pavel", "Zaharov"), -20, "CAR", 0.12D, 12);
        orderManager.addOrder(autoOrder);
        autoOrder = new CreditAutoOrder(new User(12, "Pavel", "Zaharov"), 400, "CAR", 0, 24);
        orderManager.addOrder(autoOrder);
        autoOrder = new FullPriceAutoOrder(new User(12, null, null), 500, "CAR", false);
        orderManager.addOrder(autoOrder);
        Assertions.assertEquals(820, orderManager.calculateTotalPrice().intValue());
    }
}
