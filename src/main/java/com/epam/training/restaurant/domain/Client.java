package com.epam.training.restaurant.domain;

import com.epam.training.restaurant.domain.food.Dish;
import com.epam.training.restaurant.domain.food.Extra;
import com.epam.training.restaurant.event.PlaceOrderEvent;
import lombok.Data;

import java.util.LinkedList;

@Data
public class Client {
    private double happiness;
    private LinkedList<Order> ordersToConsume;
    private Restaurant restaurant;

    public Client(double happiness, Restaurant restaurant) {
        this.happiness = happiness;
        this.restaurant = restaurant;
        this.ordersToConsume = new LinkedList<>();
    }

    public void placeOrder(Dish dish, Extra extra) {
        new PlaceOrderEvent(restaurant, new Order(dish, extra, this));
    }

    public void receiveOrder(Order order) {
        ordersToConsume.add(order);
        consume();
    }

    public void consume() {
        if (!ordersToConsume.isEmpty()) {
            happiness += ordersToConsume.pop().estimateHappiness();
        }
    }
}
