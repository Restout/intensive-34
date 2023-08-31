package ru.aston.shevtsov_ae.task1;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FullPriceAutoOrder extends AutoOrder {
    Boolean luckyDay;

    public FullPriceAutoOrder(User user, BigDecimal price, String carName, Boolean luckyDay) {
        super(user, price, carName);
        this.luckyDay = luckyDay;
    }

    @Override
    public BigDecimal calculateDiscount() {
        if (luckyDay) {
            return BigDecimal.valueOf(0.5);
        }
        return BigDecimal.ONE;
    }
}
