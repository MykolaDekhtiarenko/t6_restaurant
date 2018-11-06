package com.epam.training.restaurant.event;

import com.epam.training.restaurant.domain.Order;
import com.epam.training.restaurant.domain.Restaurant;
import com.epam.training.restaurant.core.Event;
import lombok.Data;

@Data
public class PlaceOrderEvent extends Event<Order> {
    private Order order;

    public PlaceOrderEvent(Restaurant consumer, Order order) {
        super(consumer);
        this.order = order;
    }

}
