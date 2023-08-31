package ru.aston.shevtsov_ae.task1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AutoOrder {
    private User user;
    private BigDecimal price;
    private String carName;

    public abstract BigDecimal calculateDiscount();

}
