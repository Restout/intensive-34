package ru.aston.shevtsov_ae.task1;

import lombok.Data;

@Data
public class CreditAutoOrder extends AutoOrder {
    double percentage;
    int monthsOfCredit;

    public CreditAutoOrder(User user, int price, String carName, double percentage, int monthsOfCredit) {
        super(user, price, carName);
        this.percentage = percentage;
        this.monthsOfCredit = monthsOfCredit;
    }

    @Override
    public double calculateDiscount() {
        if (monthsOfCredit >= 12 && monthsOfCredit < 24) {
            return 0.9D;
        }
        if (monthsOfCredit >= 24) {
            return 0.8D;
        }
        return 1D;
    }
}
