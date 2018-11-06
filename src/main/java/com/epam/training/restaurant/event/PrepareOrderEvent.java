package com.epam.training.restaurant.event;

import com.epam.training.restaurant.core.Event;
import com.epam.training.restaurant.domain.Order;
import com.epam.training.restaurant.domain.OrderRobot;
import lombok.Data;

@Data
public class PrepareOrderEvent extends Event<Order> {
    private Order orderToPrepare;

    public PrepareOrderEvent(Order orderToPrepare, OrderRobot consumer) {
        super(consumer);
        this.orderToPrepare = orderToPrepare;
    }
}
