package com.kodilla.good.patterns.challenges.Food2Door.producers.shops;

import com.kodilla.good.patterns.challenges.Food2Door.model.Order;
import com.kodilla.good.patterns.challenges.Food2Door.model.Product;
import com.kodilla.good.patterns.challenges.Food2Door.producers.FoodProducer;

import java.util.List;
import java.util.Map;

public class ExtraFoodShop extends FoodProducer {


    public ExtraFoodShop(String foodProducerName, List<Product> productListOfProducer) {
        super(foodProducerName, productListOfProducer);
    }

    //the shop offers a 5% discount for orders with quantity above 100
    @Override
    public double calculateDiscounts(Order order) {
        int productQuantity = getQuantityOfProducts(order);
        double discount = 0;

        if(productQuantity > 100) {
            discount = getPriceOfOrder(order) * 0.05;
            System.out.println("Order applies for a discount from " + this.getFoodProducerName());
        }

        return discount;
    }

    @Override
    public double process(Order order) {
        double basicPrice = getPriceOfOrder(order);
        double discount = calculateDiscounts(order);
        System.out.println("Ordering at: " + this.getFoodProducerName());
        System.out.println("Final price: " + (basicPrice - discount));
        return basicPrice - discount;
    }
}
