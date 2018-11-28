package com.kodilla.good.patterns.challenges.onlineshop.datatransfer;

import com.kodilla.good.patterns.challenges.onlineshop.model.Order;
import com.kodilla.good.patterns.challenges.onlineshop.model.User;

public class OrderRequest {
    private Order order;
    private User user;

    public OrderRequest(Order order, User user) {
        this.order = order;
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public User getUser() {
        return user;
    }
}
