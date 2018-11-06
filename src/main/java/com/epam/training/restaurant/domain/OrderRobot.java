package com.epam.training.restaurant.domain;

import com.epam.training.restaurant.core.Consumer;

public class OrderRobot implements Consumer<Order> {

    @Override
    public void handle(Order order) {
        order.getClient().receiveOrder(order);
    }

}
