package com.epam.training.restaurant.domain;

import com.epam.training.restaurant.domain.food.Dish;
import com.epam.training.restaurant.domain.food.Extra;
import lombok.Data;

@Data
public class Order {
    private Dish dish;
    private Extra extra;
    private Client client;

    public Order(Dish dish, Extra extra, Client client) {
        this.dish = dish;
        this.extra = extra;
        this.client = client;
    }

    public double estimateHappiness() {
        return extra.estimateModifier(dish.estimatedEffect(client));
    }
}
