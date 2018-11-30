package com.kodilla.good.patterns.challenges.Food2Door.model;

import java.util.Map;

public class Order {
    private Map<Product, Integer> productAndQuantityMap;

    public Order(Map<Product, Integer> productAndQuantityMap) {
        this.productAndQuantityMap = productAndQuantityMap;
    }

    public Map<Product, Integer> getProductAndQuantityMap() {
        return productAndQuantityMap;
    }
}
