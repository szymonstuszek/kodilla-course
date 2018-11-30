package com.kodilla.good.patterns.challenges.Food2Door.datatransfer;

public class OrderDto {
    private double priceOfOrder;
    private boolean orderSuccessful;

    public OrderDto(double priceOfOrder, boolean orderSuccessful) {
        this.priceOfOrder = priceOfOrder;
        this.orderSuccessful = orderSuccessful;
    }


}
