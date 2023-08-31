package ru.aston.shevtsov_ae.task1;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class OrderManager {
    private static Logger log = Logger.getLogger(OrderManager.class.getName());
    public final List<AutoOrder> autoOrderslist = new ArrayList<>();

    public BigDecimal calculateTotalPrice() {
        BigDecimal sum = new BigDecimal(0);
        if (autoOrderslist.isEmpty()) {
            return sum;
        }
        for (AutoOrder x : autoOrderslist) {
            if (x.getPrice().compareTo(BigDecimal.ZERO) > 0) {
                sum = sum.add(x.getPrice().multiply(x.calculateDiscount()));
            }
        }
        sum = sum.setScale(2, RoundingMode.HALF_EVEN);
        return sum;
    }


    public List<AutoOrder> getSortedOrederList() {
        try {
            return autoOrderslist.stream()
                    .sorted(Comparator.comparing(x -> x.getUser().getSourName()))
                    .toList();
        } catch (NullPointerException e) {
            log.info("NPE while sorting");
            return autoOrderslist;
        }
    }

    public void addOrder(AutoOrder order) {
        autoOrderslist.add(order);
    }
}
