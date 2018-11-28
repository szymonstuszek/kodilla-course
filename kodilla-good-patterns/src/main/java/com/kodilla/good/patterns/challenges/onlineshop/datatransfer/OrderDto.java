package com.kodilla.good.patterns.challenges.onlineshop.datatransfer;

import com.kodilla.good.patterns.challenges.onlineshop.model.Order;

public class OrderDto {
    private Order order;
    private boolean orderAccepted;

    public OrderDto(Order order, boolean orderAccepted) {
        this.order = order;
        this.orderAccepted = orderAccepted;
    }

    public Order getOrder() {
        return order;
    }

    public boolean isOrderAccepted() {
        return orderAccepted;
    }
}
