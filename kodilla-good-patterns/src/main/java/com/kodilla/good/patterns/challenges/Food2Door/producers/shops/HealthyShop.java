package com.kodilla.good.patterns.challenges.Food2Door.producers.shops;

import com.kodilla.good.patterns.challenges.Food2Door.model.Order;
import com.kodilla.good.patterns.challenges.Food2Door.model.Product;
import com.kodilla.good.patterns.challenges.Food2Door.producers.FoodProducer;

import java.util.List;
import java.util.Map;

public class HealthyShop extends FoodProducer {


    public HealthyShop(String foodProducerName, List<Product> productListOfProducer) {
        super(foodProducerName, productListOfProducer);
    }

    //the shop offers a 10% discount for orders with total price above 1000
    @Override
    public double process(Order order) {
        double orderPrice = getPriceOfOrder(order);


        if (doesApplyForDiscount(order)) {
            System.out.println("Order applies for discount at: " + this.getFoodProducerName());
            orderPrice = orderPrice * 0.9;
        }

        System.out.println("Ordering at: " + this.getFoodProducerName());
        System.out.println("Final order price: " + orderPrice);
        return orderPrice;
    }

    private boolean doesApplyForDiscount(Order order) {
        boolean appliesForDiscount = false;
        double orderPrice = getPriceOfOrder(order);

        if (orderPrice > 1000.0) {
            appliesForDiscount = true;
        }

        return appliesForDiscount;
    }
}
