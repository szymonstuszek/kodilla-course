package com.kodilla.good.patterns.challenges.Food2Door.repositories;

import com.kodilla.good.patterns.challenges.Food2Door.model.Order;

public interface OrderRepository {

    void saveOrder(Order order);
}
