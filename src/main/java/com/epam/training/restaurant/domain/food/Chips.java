package com.epam.training.restaurant.domain.food;

import com.epam.training.restaurant.domain.Client;
import lombok.Data;

@Data
public class Chips implements Dish {

    @Override
    public double estimatedEffect(Client client) {
        return client.getHappiness() * 0.05;
    }
}
