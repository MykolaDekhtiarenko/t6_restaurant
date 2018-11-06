package com.epam.training.restaurant.core;

public interface Consumer<T> {
    void handle(T param);
}
