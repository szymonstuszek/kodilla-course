package com.kodilla.good.patterns.challenges.Food2Door.repositories;

import com.kodilla.good.patterns.challenges.Food2Door.model.Order;

public class FoodOrderRepository implements OrderRepository {
    @Override
    public void saveOrder(Order order) {
        System.out.println("Saving order to repository.");
    }
}
