package com.epam.training.restaurant.domain.food;

import lombok.Data;

@Data
public class Ketchup implements Extra {

    @Override
    public double estimateModifier(double happiness) {
        return happiness * 2;
    }
}
