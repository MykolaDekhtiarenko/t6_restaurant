package com.epam.training.restaurant.factoty;

import com.epam.training.restaurant.domain.food.Chips;
import com.epam.training.restaurant.domain.food.Dish;
import com.epam.training.restaurant.domain.food.HotDog;

import java.util.Optional;

public class DishFactory {

    public static Optional<Dish> getDishByName(String name) {
        if (name.equalsIgnoreCase(Chips.class.getSimpleName())) {
            return Optional.of(new Chips());
        } else if (name.equalsIgnoreCase(HotDog.class.getSimpleName())) {
            return Optional.of(new HotDog());
        } else {
            return Optional.empty();
        }
    }


}
