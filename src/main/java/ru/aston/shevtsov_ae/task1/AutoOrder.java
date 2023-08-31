package ru.aston.shevtsov_ae.task1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AutoOrder {
    private User user;
    private int price;
    private String carName;

    public abstract double calculateDiscount();

}
