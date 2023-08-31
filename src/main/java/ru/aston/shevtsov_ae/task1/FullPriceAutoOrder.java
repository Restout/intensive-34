package ru.aston.shevtsov_ae.task1;

import lombok.Data;

@Data
public class FullPriceAutoOrder extends AutoOrder {
    public FullPriceAutoOrder(User user, int price, String carName, Boolean luckyDay) {
        super(user, price, carName);
        this.luckyDay = luckyDay;
    }

    Boolean luckyDay;

    @Override
    public double calculateDiscount() {
        if (luckyDay) {
            return 0.5D;
        }
        return 1D;
    }
}
