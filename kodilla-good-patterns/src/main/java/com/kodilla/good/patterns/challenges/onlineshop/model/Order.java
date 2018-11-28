package com.kodilla.good.patterns.challenges.onlineshop.model;

import java.util.Map;

public class Order {
    private Map<Product, Integer> orderedProductsMap;

    public Order(Map<Product, Integer> orderedProductsMap) {
        this.orderedProductsMap = orderedProductsMap;
    }

    public Map<Product, Integer> getOrderedProductsMap() {
        return orderedProductsMap;
    }
}
