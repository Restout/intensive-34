package ru.aston.shevtsov_ae.task1Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.shevtsov_ae.task1.*;

import java.math.BigDecimal;
import java.util.List;

public class OderListSortTests {
    OrderManager orderManager;

    @BeforeEach
    public void init() {
        orderManager = new OrderManager();
    }

    @Test
    public void sortWithCorrectSurnames() {
        AutoOrder autoOrder1 = new CreditAutoOrder(new User(12, "Pavel", "Zaharov"), BigDecimal.valueOf(200), "CAR", BigDecimal.valueOf(0.12), 12);
        orderManager.addOrder(autoOrder1);
        AutoOrder autoOrder2 = new CreditAutoOrder(new User(12, "Pavel", "Amarov"), BigDecimal.valueOf(400), "CAR", BigDecimal.valueOf(0.12), 24);
        orderManager.addOrder(autoOrder2);
        AutoOrder autoOrder3 = new FullPriceAutoOrder(new User(12, "Pavel", "Obarov"), BigDecimal.valueOf(500), "CAR", true);
        orderManager.addOrder(autoOrder3);
        List<AutoOrder> orderdList = orderManager.getSortedOrederList();
        Assertions.assertTrue(orderdList.indexOf(autoOrder2) == 0 && orderdList.indexOf(autoOrder3) == 1);
    }

    @Test
    public void sortWithCorrectSurnamesWithSameFirstLetter() {
        AutoOrder autoOrder1 = new CreditAutoOrder(new User(12, "Pavel", "Aaharov"), BigDecimal.valueOf(200), "CAR", BigDecimal.valueOf(0.12), 12);
        orderManager.addOrder(autoOrder1);
        AutoOrder autoOrder2 = new CreditAutoOrder(new User(12, "Pavel", "Amarov"), BigDecimal.valueOf(400), "CAR", BigDecimal.valueOf(0.12), 24);
        orderManager.addOrder(autoOrder2);
        AutoOrder autoOrder3 = new FullPriceAutoOrder(new User(12, "Pavel", "Abarov"), BigDecimal.valueOf(500), "CAR", true);
        orderManager.addOrder(autoOrder3);
        List<AutoOrder> orderdList = orderManager.getSortedOrederList();
        Assertions.assertTrue(orderdList.indexOf(autoOrder1) == 0 && orderdList.indexOf(autoOrder3) == 1);
    }

    @Test
    public void sortWithIncorrectNames() {
        AutoOrder autoOrder1 = new CreditAutoOrder(new User(12, "Pavel", "Zaharov"), BigDecimal.valueOf(200), "CAR", BigDecimal.valueOf(0.12), 12);
        orderManager.addOrder(autoOrder1);
        AutoOrder autoOrder2 = new CreditAutoOrder(new User(12, "Pavel", null), BigDecimal.valueOf(400), "CAR", BigDecimal.valueOf(0.12), 24);
        orderManager.addOrder(autoOrder2);
        AutoOrder autoOrder3 = new FullPriceAutoOrder(new User(12, "Pavel", "Obarov"), BigDecimal.valueOf(500), "CAR", true);
        orderManager.addOrder(autoOrder3);
        List<AutoOrder> orderdList = orderManager.getSortedOrederList();
        Assertions.assertEquals(orderManager.autoOrderslist, orderdList);
    }
}
