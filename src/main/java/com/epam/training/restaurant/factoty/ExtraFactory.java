package com.epam.training.restaurant.factoty;

import com.epam.training.restaurant.domain.food.Extra;
import com.epam.training.restaurant.domain.food.Ketchup;
import com.epam.training.restaurant.domain.food.Mustard;

import java.util.Optional;

public class ExtraFactory {

    public static Optional<Extra> getExtraByName(String name) {
        if (name.equalsIgnoreCase(Mustard.class.getSimpleName())) {
            return Optional.of(new Mustard());
        } else if (name.equalsIgnoreCase(Ketchup.class.getSimpleName())) {
            return Optional.of(new Ketchup());
        } else {
            return Optional.empty();
        }
    }
}
