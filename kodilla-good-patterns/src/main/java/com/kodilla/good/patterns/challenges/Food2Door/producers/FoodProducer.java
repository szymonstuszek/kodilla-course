package com.kodilla.good.patterns.challenges.Food2Door.producers;



import com.kodilla.good.patterns.challenges.Food2Door.model.Order;
import com.kodilla.good.patterns.challenges.Food2Door.model.Product;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;

public abstract class FoodProducer {
    protected Random random = new Random();
    protected String foodProducerName;
    protected List<Product> productListOfProducer;

    public FoodProducer(String foodProducerName, List<Product> productListOfProducer) {
        this.foodProducerName = foodProducerName;
        this.productListOfProducer = productListOfProducer;
    }

    public String getFoodProducerName() {
        return foodProducerName;
    }

    public boolean checkIfOrderIsValid(Order order) {
        boolean areAllProductsAvailable = true;

        int simulateAvailabilityCheck = random.nextInt(100);
        if (simulateAvailabilityCheck == 0) {
            areAllProductsAvailable = false;
        }

        return areAllProductsAvailable;
    }

    public abstract double process(Order order);

    public double calculateDiscounts(Order order) {
        return 0;
    }

    public double getPriceOfOrder(Order order) {
        Map<Product, Integer> orderedProductsWithQuantityMap = order.getProductAndQuantityMap();

        double orderPrice = 0;
        for(Map.Entry<Product, Integer> entry: orderedProductsWithQuantityMap.entrySet()) {
            orderPrice += entry.getKey().getProductPrice() * entry.getValue().intValue();
        }

        return orderPrice;
    }

    protected int getQuantityOfProducts(Order order) {
        Map<Product, Integer> productAndQuantityMap = order.getProductAndQuantityMap();

        int productQuantity = productAndQuantityMap.values().stream()
                .mapToInt(Number::intValue).sum();

        return productQuantity;
    }
}
