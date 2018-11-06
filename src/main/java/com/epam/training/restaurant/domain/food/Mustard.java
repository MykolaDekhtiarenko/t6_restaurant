package com.epam.training.restaurant.domain.food;

import lombok.Data;

@Data
public class Mustard implements Extra {
    @Override
    public double estimateModifier(double happiness) {
        return 1;
    }
}
