package ru.aston.shevtsov_ae.task1Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.aston.shevtsov_ae.task1.*;

import java.util.List;

public class OderListSortTests {
    @Test
    public void sortWithCorrectSurnames() {
        OrderManager orderManager = new OrderManager();
        AutoOrder autoOrder1 = new CreditAutoOrder(new User(12, "Pavel", "Zaharov"), 200, "CAR", 0.12D, 12);
        orderManager.addOrder(autoOrder1);
        AutoOrder autoOrder2 = new CreditAutoOrder(new User(12, "Pavel", "Amarov"), 400, "CAR", 0.12D, 24);
        orderManager.addOrder(autoOrder2);
        AutoOrder autoOrder3 = new FullPriceAutoOrder(new User(12, "Pavel", "Obarov"), 500, "CAR", true);
        orderManager.addOrder(autoOrder3);
        List<AutoOrder> orderdList = orderManager.getSortedOrederList();
        Assertions.assertTrue(orderdList.indexOf(autoOrder2) == 0 && orderdList.indexOf(autoOrder3) == 1);
    }

    @Test
    public void sortWithCorrectSurnamesWithSameFirstLetter() {
        OrderManager orderManager = new OrderManager();
        AutoOrder autoOrder1 = new CreditAutoOrder(new User(12, "Pavel", "Aaharov"), 200, "CAR", 0.12D, 12);
        orderManager.addOrder(autoOrder1);
        AutoOrder autoOrder2 = new CreditAutoOrder(new User(12, "Pavel", "Amarov"), 400, "CAR", 0.12D, 24);
        orderManager.addOrder(autoOrder2);
        AutoOrder autoOrder3 = new FullPriceAutoOrder(new User(12, "Pavel", "Abarov"), 500, "CAR", true);
        orderManager.addOrder(autoOrder3);
        List<AutoOrder> orderdList = orderManager.getSortedOrederList();
        Assertions.assertTrue(orderdList.indexOf(autoOrder1) == 0 && orderdList.indexOf(autoOrder3) == 1);
    }

    @Test
    public void sortWithIncorrectNames() {
        OrderManager orderManager = new OrderManager();
        AutoOrder autoOrder1 = new CreditAutoOrder(new User(12, "Pavel", "Aaharov"), 200, "CAR", 0.12D, 12);
        orderManager.addOrder(autoOrder1);
        AutoOrder autoOrder2 = new CreditAutoOrder(new User(12, "Pavel", null), 400, "CAR", 0.12D, 24);
        orderManager.addOrder(autoOrder2);
        AutoOrder autoOrder3 = new FullPriceAutoOrder(new User(12, "Pavel", "Abarov"), 500, "CAR", true);
        orderManager.addOrder(autoOrder3);
        List<AutoOrder> orderdList = orderManager.getSortedOrederList();
        Assertions.assertEquals(orderManager.autoOrderslist, orderdList);
    }
}
