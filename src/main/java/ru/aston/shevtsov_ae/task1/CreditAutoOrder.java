package ru.aston.shevtsov_ae.task1;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditAutoOrder extends AutoOrder {
    BigDecimal percentage;
    int monthsOfCredit;

    public CreditAutoOrder(User user, BigDecimal price, String carName, BigDecimal percentage, int monthsOfCredit) {
        super(user, price, carName);
        this.percentage = percentage;
        this.monthsOfCredit = monthsOfCredit;
    }

    @Override
    public BigDecimal calculateDiscount() {
        if (monthsOfCredit >= 12 && monthsOfCredit < 24) {
            return BigDecimal.valueOf(0.9);
        }
        if (monthsOfCredit >= 24) {
            return BigDecimal.valueOf(0.8);
        }
        return BigDecimal.valueOf(1);
    }
}
