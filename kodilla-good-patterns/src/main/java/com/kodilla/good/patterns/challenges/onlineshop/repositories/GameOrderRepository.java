package com.kodilla.good.patterns.challenges.onlineshop.repositories;

import com.kodilla.good.patterns.challenges.onlineshop.model.Order;
import com.kodilla.good.patterns.challenges.onlineshop.model.User;

public class GameOrderRepository implements OrderRepository {
    @Override
    public void saveOrder(Order order, User user) {
        System.out.printf("The order from user %s has been saved.", user.getUsername());
    }
}
