package com.epam.training.restaurant.domain.food;

import com.epam.training.restaurant.domain.Client;
import lombok.Data;

@Data
public class HotDog implements Dish {

    @Override
    public double estimatedEffect(Client client) {
        return 2;
    }
}
