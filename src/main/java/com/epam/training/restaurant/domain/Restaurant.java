package com.epam.training.restaurant.domain;

import com.epam.training.restaurant.core.Consumer;
import com.epam.training.restaurant.event.PrepareOrderEvent;
import lombok.Data;

import java.util.LinkedList;

@Data
public class Restaurant implements Runnable, Consumer<Order> {
    private LinkedList<Order> orders;
    private OrderRobot robot;
    private boolean open;

    public Restaurant(boolean open) {
        this.open = open;
        this.orders = new LinkedList<>();
        this.robot = new OrderRobot();
    }

    @Override
    public void handle(Order order) {
        orders.add(order);
    }

    @Override
    public void run() {
        while (open) {
            if (!orders.isEmpty()) {
                Order toPrepare = orders.pop();
                new PrepareOrderEvent(toPrepare, robot);
            }
        }
    }

    public void close() {
        this.open = false;
    }
}
