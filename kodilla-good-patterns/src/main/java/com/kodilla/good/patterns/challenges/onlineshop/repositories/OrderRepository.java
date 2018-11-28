package com.kodilla.good.patterns.challenges.onlineshop.repositories;

import com.kodilla.good.patterns.challenges.onlineshop.model.Order;
import com.kodilla.good.patterns.challenges.onlineshop.model.User;

public interface OrderRepository {

    void saveOrder(Order order, User user);
}
