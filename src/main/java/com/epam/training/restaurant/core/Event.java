package com.epam.training.restaurant.core;

public abstract class Event<T> {
    private Consumer consumer;

    public Event(Consumer consumer) {
        this.consumer = consumer;
    }

    public void fire(T param) {
       consumer.handle(param);
    }

}
